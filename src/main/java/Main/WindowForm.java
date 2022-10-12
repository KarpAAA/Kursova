package Main;

import Data.Car;
import Dialogs.*;
import FormParts.IconButton;
import FormParts.Table;
import FormParts.TaskButton;
import Task.TasksClass;
import Utilities.SortingClass;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;



public class WindowForm {
    final static private String[] taskConditions = {
        "За заданою маркою авто визначити найдешевшу та найменш потужну(одночасно),передбачити наявність декількох однакових результатів"
            ,"Вивести марки авто в яких однакова ціна та різні кольори"
            ,"Визначити марки авто ціна яких входить в задані межі"
            ,"В кожній марці авто визначити найпотужнішу червоного кольору та найдешевшу чорного кольору"
            ,"Для кожного кольору визначити мінімальну та максимальну ціну авто"
    };
    final static private Color mainColor = new Color(74, 97, 78);
    private static WindowForm instance;
    private Table table;

    private JPanel createPanelTable() {
        JPanel panelTable = new JPanel();
        panelTable.setBounds(20, 20, 742, 243);
        panelTable.setOpaque(false);

        table = new Table();
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(742, 243));
        panelTable.add(sp);

        return panelTable;
    }
    private JPanel createPanelTaskButtons() {
        Border emptyBorder = BorderFactory.createEmptyBorder();

        JPanel panelTaskButtons = new JPanel();
        panelTaskButtons.setBackground(mainColor);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 37, 0);
        panelTaskButtons.setLayout(fl);
        panelTaskButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);



        JButton task2 = new TaskButton("Task2", "Task", () -> {
            System.out.println("Task2");
            new TaskDialog(mainColor,new TaskDialogStructure("Task2", taskConditions[0], true),
                    (String value) -> table.setDataToTable(TasksClass.f2(table.getDataList(),value)));
        });
        JButton task3 = new TaskButton("Task3", "Task", () -> {
            System.out.println("Task3");
            new TaskDialog(mainColor,new TaskDialogStructure("Task3", taskConditions[1], false),
                    () -> table.setDataToTable(TasksClass.f3(table.getDataList())));
        });
        JButton task4 = new TaskButton("Task4", "Task", () -> {
            System.out.println("Task4");
            new TaskDialog(mainColor,new TaskDialogStructure("Task4", taskConditions[2], true),
                    (String value) -> table.setDataToTable(TasksClass.f4(table.getDataList(),value)));
        });

        JButton task5 = new TaskButton("Task5", "Task", () -> {
            System.out.println("Task5");
            new TaskDialog(mainColor, new TaskDialogStructure(
                    "Task5",
                    taskConditions[3], false),
                    () ->{ table.setDataToTable(TasksClass.f5(table.getDataList()));
            });

        });

        JButton task6 = new TaskButton("Task6", "Task", () -> {
            System.out.println("Task6");
            new TaskDialog(mainColor, new TaskDialogStructure("Task6",
                    taskConditions[4],false),
                    () -> {
                        table.setDataToTable(TasksClass.f6(table.getDataList()));
                    });
        });

        String[] boxOptions = {"NONE", "Sort by price", "Sort by color", "Sort by efficiency", "Sort by mark"};
        JComboBox<String> sortBy = new JComboBox<>(boxOptions);
        sortBy.setPreferredSize(new Dimension(100, 30));
        sortBy.setBackground(Color.WHITE);
        sortBy.setBorder(emptyBorder);
        sortBy.setFocusable(false);
        sortBy.addActionListener(e -> {
            String selectedItem = (String) sortBy.getSelectedItem();
            if (selectedItem == null) return;
            comboBoxSwitcher(selectedItem);

        });



        panelTaskButtons.add(task2);
        panelTaskButtons.add(task3);
        panelTaskButtons.add(task4);
        panelTaskButtons.add(task5);
        panelTaskButtons.add(task6);
        panelTaskButtons.add(sortBy);

        panelTaskButtons.setBounds(20, 20 + 243 + 20, 742, 50);


        return panelTaskButtons;
    }
    private JPanel createPanelControlButtons() {

        JPanel panelTaskButtons = new JPanel();
        panelTaskButtons.setBackground(mainColor);
        panelTaskButtons.setLayout(null);
        panelTaskButtons.setBounds(20, 20 + 243 + 20 + 20 + 50, 742, 570 - 243 - 50 - 120);
        panelTaskButtons.setAlignmentY(Component.BOTTOM_ALIGNMENT);


        Icon iconDelete = new ImageIcon("C:\\Users\\ivank\\IdeaProjects\\Kursova\\src\\main\\resources\\Delete.png");
        Icon iconPlus = new ImageIcon("C:\\Users\\ivank\\IdeaProjects\\Kursova\\src\\main\\resources\\Plus.png");
        Icon iconReload = new ImageIcon("C:\\Users\\ivank\\IdeaProjects\\Kursova\\src\\main\\resources\\Reload.png");


        JButton buttonDelete = new IconButton(iconDelete, new Rectangle(300, 112, 30, 28));
        buttonDelete.addActionListener(e -> new DeleteDialog(mainColor, id -> {
            table.deleteCarFromTable(id);
        }));

        JButton buttonPLus = new IconButton(iconPlus, new Rectangle(350, 105, 42, 46));
        buttonPLus.addActionListener((e) -> new AddDialog(mainColor, car -> {
            if (car != null) table.addCarToTable(car);

        }));

        JButton buttonReload = new IconButton(iconReload, new Rectangle(414, 112, 29, 30));
        buttonReload.addActionListener(e -> {
            new ConfirmationDialog(mainColor, () -> {
                table.reloadData();
            });
        });

        panelTaskButtons.add(buttonDelete);
        panelTaskButtons.add(buttonPLus);
        panelTaskButtons.add(buttonReload);


        return panelTaskButtons;
    }

    private WindowForm() {

        JFrame frame = new JFrame("Kursova");
        JPanel panelTable = createPanelTable();
        JPanel panelTaskButtons = createPanelTaskButtons();
        JPanel panelControlButtons = createPanelControlButtons();

        formInit(frame);


        addingPanelsToForm(frame, panelTable, panelTaskButtons, panelControlButtons);

        frame.setVisible(true);
    }

    private void addingPanelsToForm(JFrame frame, JPanel panelTable, JPanel panelTaskButtons, JPanel panelControlButtons) {
        frame.add(panelTable);
        frame.add(panelTaskButtons);
        frame.add(panelControlButtons);
    }
    private void formInit(JFrame frame) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(new Dimension(794, 570));
        frame.getContentPane().setBackground(mainColor);

    }
    private void comboBoxSwitcher(String selectedItem) {
        List<Car> dataList = table.getCurrentTableData();
        switch (selectedItem) {
            case "Sort by price" -> {
                SortingClass.mergeSort(dataList, SortingClass.SortByEnum.PRICE, dataList.size());
                table.setDataToTable(dataList);
            }
            case "Sort by color" -> {
                SortingClass.mergeSort(dataList, SortingClass.SortByEnum.COLOR, dataList.size());
                table.setDataToTable(dataList);
            }
            case "Sort by efficiency" -> {
                SortingClass.mergeSort(dataList, SortingClass.SortByEnum.EFFICIENCY, dataList.size());
                table.setDataToTable(dataList);
            }
            case "Sort by mark" -> {
                SortingClass.mergeSort(dataList, SortingClass.SortByEnum.MARK, dataList.size());
                table.setDataToTable(dataList);
            }
            default -> {
                table.reloadData();
            }
        }
    }


    public static WindowForm getScreenInstance() {
        if (instance == null) {
            instance = new WindowForm();
        }
        return instance;
    }
}
