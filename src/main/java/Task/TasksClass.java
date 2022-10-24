package Task;

import Data.Car;

import java.util.*;
import java.util.stream.Collectors;

public class TasksClass {
    private TasksClass() {}


    public static List<Car> f2(List<Car> list, String value) {
        List<Car> resultList = new ArrayList<>();
        var res = list.stream().filter( car -> car.mark().equals(value))
                .min(Comparator.comparingDouble(Car::price));
        double minPrice = 0;
        if(res.isPresent()) {
            minPrice = res.get().price();
            resultList.add(res.get());
        }
        double finalMinPrice = minPrice;
        list = list.stream().filter(car -> car.price() == finalMinPrice && car.mark().equals(value)).collect(Collectors.toList());
        if(list.size()!=1 || list.size()!=0){
            var optional = list.stream().min(Comparator.comparing(Car::efficiency));
            Car carMin = null;
            if(optional.isPresent()) carMin = optional.get();
            Car finalCarMin = carMin;
            resultList = list.stream().filter(car -> car.efficiency() == finalCarMin.efficiency()).collect(Collectors.toList());
        }
        return resultList;
    }

    public static List<Car> f3(List<Car> list) {
        List<Car> resultList = new ArrayList<>();
        Set<String> markList  = new HashSet<>();
        Map<Double,List<Car>> map = list.stream().collect(Collectors.groupingBy(Car::price));

        Set<String> colorList = new HashSet<>();

        for(var entry : map.entrySet()){
            if(entry.getValue().size()<2) continue;
            for(var car: entry.getValue()){
               if(!colorList.contains(car.color())){
                   colorList.add(car.color());
                   markList.add(car.mark());
                   resultList.add(car);
               }
            }
        }

        return resultList;

    }

    public static List<Car> f4(List<Car> list, String value) {
        String[] range = value.split("-");
        double range1 = Double.parseDouble(range[0]);
        double range2 = Double.parseDouble(range[1]);

        return list.stream().filter( car ->
            car.price()>=range1 && car.price()<=range2
        ).collect(Collectors.toList());
    }

    public static List<Car> f5(List<Car> list) {
        List<Car> result = new ArrayList<>();
        Map<String,List<Car>>  map = list.stream().collect(Collectors.groupingBy(Car::mark));
        var set = map.entrySet();

        Map<String,List<Car>>  redMap = new HashMap<>();
        Map<String,List<Car>>  blackMap = new HashMap<>();

        for(var entry:set){
            List<Car> carList = new ArrayList<>();
            for(var car:entry.getValue()){
                if(car.color().compareToIgnoreCase("red") == 0 ){
                    carList.add(car);
                }
            }
            if(carList.size()!=0)redMap.put(entry.getKey(),carList);
        }

        for(var entry:set){
            List<Car> carList = new ArrayList<>();
            for(var car:entry.getValue()){
                if(car.color().compareToIgnoreCase("black") == 0 ){
                    carList.add(car);
                }
            }
            if(carList.size()!=0)blackMap.put(entry.getKey(),carList);
        }

        for(var entry:redMap.entrySet()){
            double max = findMaxEfficiency(entry.getValue());
            var foundValue = entry.getValue().stream().filter(car -> car.efficiency() == max).findFirst();
            if(foundValue.isPresent())result.add(foundValue.get());
        }

        for(var entry:blackMap.entrySet()){
            double min = findMinPrice(entry.getValue());
            var foundValue = entry.getValue().stream().filter(car -> car.price() == min).findFirst();
            if(foundValue.isPresent())result.add(foundValue.get());
        }
        return result;
    }

    private static double findMaxEfficiency(List<Car> list){
        double max = 0;
        for(var car:list){
            if(car.efficiency()>max)max = car.efficiency();
        }
        return max;
    }
    private static double findMinPrice(List<Car> list){
        double min = list.get(0).price();
        for(var car:list){
            if(car.price()<min)min = car.price();
        }
        return min;
    }
    public static List<Car> f6(List<Car> list) {
        List<Car> resultList = new ArrayList<>();

        Map<String, List<Car>> map = list.stream().collect(Collectors.groupingBy(Car::color));

        map.entrySet().stream().forEach( entry -> resultList.addAll(findMinMax(entry.getValue())));

        return resultList;
    }
    private static List<Car> findMinMax(List<Car> carList){
        double min = carList.get(0).price();
        double max = carList.get(0).price();
        int minIndex = 0;
        int maxIndex = 0;

        int k=0;
        for(var car:carList){
            if(min > car.price()){
                min = car.price();
                minIndex = k;
            }
            if(max < car.price()){
                max = car.price();
                maxIndex = k;
            }

            ++k;
        }
        double minCopy = min;
        double maxCopy = max;
        return carList.stream().filter( car -> car.price() == minCopy|| car.price() ==maxCopy).collect(Collectors.toList());

    }



}