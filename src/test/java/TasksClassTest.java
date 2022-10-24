import Data.Car;
import Task.TasksClass;
import Utilities.SortingClass;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        /*testList.add( new Car("Audi","Blue", 12000, 678));
        testList.add( new Car("Bmw","Red", 12000, 555));
        testList.add( new Car("Ford","Green", 12000, 145));
        testList.add( new Car("Tesla","Black", 12000, 359));
        testList.add( new Car("Porsche","Orange", 12000, 1802));
        testList.add( new Car("Ferrari","White", 12000, 295));*/

        List<Car> expectedList = List.of( new Car("Audi","Red", 11000, 250)
                ,new Car("Bmw","Blue", 11000, 150)
                ,new Car("Tesla","Green", 11000, 389));
        List<Car> actualList = TasksClass.f3(testList);

        SortingClass.mergeSort(actualList, SortingClass.SortByEnum.MARK,actualList.size());

        Assert.assertEquals(expectedList,actualList);

    }

    @Test
    public  void testF4() {
        Assert.assertEquals(4, 2 + 2);
        Assert.assertTrue(4 == 2 + 2);
    }

    @Test
    public  void testF5() {
        Assert.assertEquals(4, 2 + 2);
        Assert.assertTrue(4 == 2 + 2);
    }

    @Test
    public  void testF6() {
        Assert.assertEquals(4, 2 + 2);
        Assert.assertTrue(4 == 2 + 2);
    }


}
