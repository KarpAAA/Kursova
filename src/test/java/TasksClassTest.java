import Data.Car;
import Task.TasksClass;
import Utilities.SortingClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class TasksClassTest {

    @Test
    public  void testF2() {
        List<Car> testList = new ArrayList<>();
        testList.add( new Car("Audi","Red", 11000, 232));
        testList.add( new Car("Audi","Blue", 50000, 638));
        testList.add( new Car("Audi","Green", 11000, 231));
        testList.add( new Car("Audi","Green", 56000, 660));
        testList.add( new Car("Audi","White", 14000, 250));
        testList.add( new Car("Audi","Blue", 59800, 578));
        testList.add( new Car("Audi","White", 141000, 251));
        testList.add( new Car("Audi","Red", 56000, 478));

        List<Car> actualList = TasksClass.f2(testList, "Audi");
        List<Car> expectedList = List.of(new Car("Audi","Green", 11000, 231));

        Assert.assertEquals(actualList,expectedList);


        //if some similar cars in list
        List<Car> testList1 = new ArrayList<>();
        testList1.add( new Car("Audi","Red", 11000, 232));
        testList1.add( new Car("Audi","Blue", 50000, 638));
        testList1.add( new Car("Audi","Green", 11000, 232));

        actualList = TasksClass.f2(testList1, "Audi");
        List<Car> expectedList1 = List.of(new Car("Audi","Red", 11000, 232),
                new Car("Audi","Green", 11000, 232));

        Assert.assertEquals(expectedList1,actualList);


        //if none  cars with such model in list
        actualList = TasksClass.f2(testList1, "Bmw");
        Assert.assertEquals(new ArrayList<>(),actualList);



    }

    @Test
    public  void testF3() {
        //Marks with the same price and other colors

        List<Car> testList = new ArrayList<>();
        testList.add( new Car("Audi","Red", 12000, 250));
        testList.add( new Car("Bmw","Blue", 12000, 150));
        testList.add( new Car("Ford","Black", 121000, 340));
        testList.add( new Car("Tesla","Green", 11000, 389));
        testList.add( new Car("Porsche","White", 13000, 112));
        testList.add( new Car("Ferrari","Red", 11000, 195));



        List<Car> expectedList = List.of( new Car("Audi","Red", 12000, 250)
                ,new Car("Bmw","Blue", 12000, 150)
                ,new Car("Ferrari","Red", 11000, 195)
                ,new Car("Tesla","Green", 11000, 389));
        List<Car> actualList = TasksClass.f3(testList);

        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());

        Assert.assertEquals(expectedList,actualList);


        //case checking models
        Set<String> actualModels = new HashSet<>();
        actualList.forEach(car -> actualModels.add(car.mark()));
        List<String> expectedModelsList = List.of("Ferrari","Audi","Tesla", "Bmw");

        Assert.assertEquals(expectedModelsList.toString(),actualModels.toString());



        //case two models with same color
        testList.add( new Car("Audi","Red", 12000, 395));
        testList.add( new Car("Audi","Red", 12000, 365));

        actualList = TasksClass.f3(testList);
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());
        Assert.assertEquals(expectedList,actualList);



        //case no price mathces
        List<Car> testList1 = new ArrayList<>();
        testList1.add( new Car("Audi","Red", 12000, 250));
        testList1.add( new Car("Bmw","Blue", 13000, 150));
        testList1.add( new Car("Ford","Black", 121000, 340));
        testList1.add( new Car("Tesla","Green", 14000, 389));
        testList1.add( new Car("Porsche","White", 15000, 112));
        testList1.add( new Car("Ferrari","Red", 16000, 195));

        actualList = TasksClass.f3(testList1);
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());
        Assert.assertEquals(new ArrayList<>(),actualList);





    }

    @Test
    public  void testF4() {
        List<Car> testList = new ArrayList<>();

        testList.add( new Car("Audi","Red", 12000, 250));
        testList.add( new Car("Bmw","Blue", 12000, 150));
        testList.add( new Car("Ford","Black", 121000, 340));
        testList.add( new Car("Tesla","Green", 11000, 389));
        testList.add( new Car("Porsche","White", 13000, 112));
        testList.add( new Car("Ferrari","Red", 11000, 195));
        testList.add( new Car("Audi","Red", 11000, 232));
        testList.add( new Car("Audi","Blue", 50000, 638));
        testList.add( new Car("Bmw","Green", 11000, 231));
        testList.add( new Car("Ferrari","Green", 56000, 660));
        testList.add( new Car("Bmw","White", 14000, 250));
        testList.add( new Car("Audi","Blue", 59800, 578));
        testList.add( new Car("Ferrari","White", 141000, 251));
        testList.add( new Car("Bmw","Red", 67000, 478));




        List<Car> expectedList = List.of(new Car("Audi","Blue", 50000, 638),
                new Car("Ferrari","Green", 56000, 660),
                new Car("Audi","Blue", 59800, 578),
                new Car("Bmw","Red", 67000, 478));
        List<Car> actualList = TasksClass.f4(testList,"15000-100000");

        Assert.assertEquals(expectedList,actualList);



        //Check models
        Set<String> actualModels = new HashSet<>();
        actualList.forEach(car -> actualModels.add(car.mark()));
        List<String> expectedModelsList = List.of("Ferrari","Audi","Bmw");

        Assert.assertEquals(expectedModelsList.toString(),actualModels.toString());

    }

    @Test
    public  void testF5() {
        List<Car> testList = new ArrayList<>();

        testList.add( new Car("Audi","Black", 98000, 250));
        testList.add( new Car("Bmw","Red", 12000, 150));
        testList.add( new Car("Ford","Black", 101000, 440));
        testList.add( new Car("Tesla","Red", 11000, 390));
        testList.add( new Car("Porsche","Black", 23100, 112));

        testList.add( new Car("Audi","Black", 12000, 250));
        testList.add( new Car("Bmw","Red", 12000, 350));
        testList.add( new Car("Ford","Black", 121000, 340));
        testList.add( new Car("Tesla","Red", 150000, 389));
        testList.add( new Car("Porsche","Black", 13000, 112));

        List<Car> expectedList = List.of(new Car("Audi","Black", 12000, 250),
                new Car("Bmw","Red", 12000, 350),
                new Car("Ford","Black", 101000, 440),
                new Car("Porsche","Black", 13000, 112),
                new Car("Tesla","Red", 11000, 390)
                );

        List<Car> actualList = TasksClass.f5(testList);
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());

        Assert.assertEquals(expectedList,actualList);

        //case only one Mark
        actualList = TasksClass.f5(List.of(new Car("Audi", "Red",11111,150),
                new Car("Audi", "Black",10000,150),
                new Car("Audi", "Red",11111,250),
                new Car("Audi", "Black",11111,150)));

        Assert.assertEquals(List.of(
                new Car("Audi", "Red",11111,250),
                new Car("Audi", "Black",10000,150)),actualList);


        //case no cars with necessary color
        actualList = TasksClass.f5(List.of(new Car("Audi", "Blue",11111,150),
                new Car("Audi", "Orange",11111,150),
                new Car("Audi", "Yellow",11111,150),
                new Car("Audi", "Green",11111,150)));
        Assert.assertEquals(new ArrayList<>(),actualList);

        //case no cars
        actualList = TasksClass.f5(new ArrayList<>());
        Assert.assertEquals(new ArrayList<>(),actualList);
    }

    @Test
    public  void testF6() {
        List<Car> testList = new ArrayList<>();

        testList.add( new Car("Audi","Red", 12000, 250));
        testList.add( new Car("Audi","Red", 11000, 232));
        testList.add( new Car("Audi","Red", 50000, 638));
        testList.add( new Car("Audi","Red", 59800, 578));

        testList.add( new Car("Bmw","Green", 11000, 231));
        testList.add( new Car("Bmw","Green", 67000, 478));
        testList.add( new Car("Bmw","Green", 14000, 250));
        testList.add( new Car("Bmw","Green", 12000, 150));

        testList.add( new Car("Ford","Black", 121000, 340));

        testList.add( new Car("Tesla","Blue", 11000, 389));

        testList.add( new Car("Porsche","Orange", 13000, 112));

        testList.add( new Car("Ferrari","White", 11000, 195));
        testList.add( new Car("Ferrari","White", 56000, 660));
        testList.add( new Car("Ferrari","White", 141000, 251));


        List<Car> expectedList = List.of(
                new Car("Audi","Red", 11000, 232),
                new Car("Audi","Red", 59800, 578),
                new Car("Bmw","Green", 11000, 231),
                new Car("Bmw","Green", 67000, 478),
                new Car("Ferrari","White", 11000, 195),
                new Car("Ferrari","White", 141000, 251),
                new Car("Ford","Black", 121000, 340),
                new Car("Porsche","Orange", 13000, 112),
                new Car("Tesla","Blue", 11000, 389)

        );

        List<Car> actualList = TasksClass.f6(testList);
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.PRICE,actualList.size());
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());

        Assert.assertEquals(expectedList,actualList);

        //only one color
        actualList = TasksClass.f6(List.of(  new Car("Audi","Red", 12000, 232),
                new Car("Audi","Red", 59800, 578),
                new Car("Bmw","Red", 121000, 231),
                new Car("Bmw","Red", 67000, 478),
                new Car("Ferrari","Red", 16000, 195),
                new Car("Ferrari","Red", 141000, 251)));
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.PRICE,actualList.size());
        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());

        Assert.assertEquals(List.of(
                new Car("Audi","Red", 12000, 232),
                new Car("Ferrari","Red", 141000, 251)
        ),actualList);

        //only one car
        actualList = TasksClass.f6(List.of( new Car("Audi","Red", 140000, 232)));
        Assert.assertEquals(List.of(
                new Car("Audi","Red", 140000, 232)
        ),actualList);

        //empty list
        actualList = TasksClass.f6(new ArrayList<>());
        Assert.assertEquals(new ArrayList<>(),actualList);

    }


}
