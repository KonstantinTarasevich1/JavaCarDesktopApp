
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class carsFrame extends JFrame {
    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;
    int id = -1;
    int idman = -1;
    int idown = -1;
    int idspr = -1;
    JTabbedPane tab = new JTabbedPane();
    JPanel carPanel = new JPanel();
    JPanel carPanel1 = new JPanel();
    JPanel carPanel2 = new JPanel();
    JPanel carPanel3 = new JPanel();
    JLabel brandL = new JLabel("Марка");
    JLabel modelL = new JLabel("Модел");
    JLabel carTypeL = new JLabel("Вид автомобил");
    JLabel licencePlateL = new JLabel("Регистрационен номер");
    JLabel yearL = new JLabel("Година");
    JLabel colorL = new JLabel("Цвят");
    JLabel priceL = new JLabel("Цена");
    JLabel transmissionL = new JLabel("Тип скоростна кутия");
    JLabel ownerL = new JLabel("Собственик:");

    JTextField modelTF = new JTextField();
    JTextField licencePlateTF = new JTextField();
    JTextField yearTF = new JTextField();
    JTextField colorTF = new JTextField();
    JTextField priceTF = new JTextField();
    JTextField carColourSearchTF = new JTextField();
    String[] carType = new String[]{"Купе", "Седан", "Комби", "Хечбек", "Джип"};
    JComboBox<String> carTypeCombo = new JComboBox<>(carType);
    String[] carTransmission = new String[]{"Автоматична", "Ръчна", "Хибридна"};
    JComboBox<String> transmissionCombo = new JComboBox<>(carTransmission);
    JComboBox<String> comboManufacturer = new JComboBox<>();
    JComboBox<String> comboOwner = new JComboBox<>();
    JButton BAdd = new JButton("Добави");
    JButton BDel = new JButton("Изтрий");
    JButton BEdit = new JButton("Промени");
    JButton carSearch = new JButton("Търси кола по цвят");
    JTable carTable = new JTable();
    JTable carSearchTable = new JTable();
    JScrollPane carScroll;
    JScrollPane carSearchScroll;
    JLabel ownerFirstNameL;
    JTextField ownerFirstNameTF;
    JLabel ownerLastNameL;
    JTextField ownerLastNameTF;
    JLabel ownerPhoneNumberL;
    JTextField ownerPhoneNumberTF;
    JLabel ownerEmailL;
    JTextField ownerEmailTF;
    JTextField ownerSearchLastNameTF;
    JPanel ownerPanel;
    JPanel ownerPanel1;
    JPanel ownerPanel2;
    JPanel ownerPanel3;
    JButton ownerAdd;
    JButton ownerDel;
    JButton ownerEdit;
    JButton ownerSearch;
    JTable ownerTable;
    JTable ownerSearchTable;
    JScrollPane ownerScroll;
    JScrollPane ownerSearchScroll;
    JLabel manNameL = new JLabel("");
    JTextField manNameTF;
    JLabel manCountryL;
    JTextField manCountryTF;
    JTextField manSearchCountryTF;
    JPanel manPanel;
    JPanel manPanel1;
    JPanel manPanel2;
    JPanel manPanel3;
    JButton manAdd;
    JButton manDel;
    JButton manEdit;
    JButton manSearch;
    JTable manTable;
    JTable manSearchTable;
    JScrollPane manScroll;
    JScrollPane manSearchScroll;
    JLabel sprCarYearL;
    JLabel sprCarCountryL;
    JTextField sprCarYearTF;
    JTextField sprCarCountryTF;
    JPanel sprPanel;
    JPanel sprPanel1;
    JPanel sprPanel2;
    JPanel sprPanel3;
    JButton sPrSearch;
    JTable sprTable;
    JScrollPane sprScroll;

    public carsFrame() {
        this.carScroll = new JScrollPane(this.carTable);
        this.carSearchScroll = new JScrollPane(this.carSearchTable);
        this.ownerFirstNameL = new JLabel("Първо име:");
        this.ownerFirstNameTF = new JTextField();
        this.ownerLastNameL = new JLabel("Фамилия:");
        this.ownerLastNameTF = new JTextField();
        this.ownerPhoneNumberL = new JLabel("Телефонен номер:");
        this.ownerPhoneNumberTF = new JTextField();
        this.ownerEmailL = new JLabel("Имейл:");
        this.ownerEmailTF = new JTextField();
        this.ownerSearchLastNameTF = new JTextField();
        this.ownerPanel = new JPanel();
        this.ownerPanel1 = new JPanel();
        this.ownerPanel2 = new JPanel();
        this.ownerPanel3 = new JPanel();
        this.ownerAdd = new JButton("Добави");
        this.ownerDel = new JButton("Изтрий");
        this.ownerEdit = new JButton("Промени");
        this.ownerSearch = new JButton("Търси по фамилия");
        this.ownerSearchTable = new JTable();
        this.ownerTable = new JTable();
        this.ownerScroll = new JScrollPane(this.ownerTable);
        this.ownerSearchScroll = new JScrollPane(this.ownerSearchTable);
        this.manNameL = new JLabel("Име на производител:");
        this.manNameTF = new JTextField();
        this.manCountryL = new JLabel("Държава:");
        this.manCountryTF = new JTextField();
        this.manPanel = new JPanel();
        this.manPanel1 = new JPanel();
        this.manPanel2 = new JPanel();
        this.manPanel3 = new JPanel();
        this.manAdd = new JButton("Добави");
        this.manDel = new JButton("Изтрий");
        this.manEdit = new JButton("Промени");
        this.manSearch = new JButton("Търси по държава");
        this.manSearchCountryTF = new JTextField();
        this.manSearchTable = new JTable();
        this.manTable = new JTable();
        this.manScroll = new JScrollPane(this.manTable);
        this.manSearchScroll = new JScrollPane(this.manSearchTable);
        this.sprCarYearL = new JLabel("Въведете максимална година:");
        this.sprCarYearTF = new JTextField();
        this.sprCarCountryL = new JLabel("Въведете държавата на производителя на колата:");
        this.sprCarCountryTF = new JTextField();
        this.sprPanel = new JPanel();
        this.sprPanel1 = new JPanel();
        this.sprPanel2 = new JPanel();
        this.sprPanel3 = new JPanel();
        this.sPrSearch = new JButton("Търси");
        this.sprTable = new JTable();
        this.sprScroll = new JScrollPane(this.sprTable);
        this.conn = DbConnection.getConnection();
        this.setSize(600, 720);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Автомобилна система");
        this.tab.add(this.carPanel, "Коли");
        this.carPanel.setLayout(new GridLayout(3, 1));
        this.carPanel.add(this.carPanel1);
        this.carPanel1.setLayout(new GridLayout(9, 2));
        this.carPanel1.add(this.brandL);
        this.carPanel1.add(this.comboManufacturer);
        this.carPanel1.add(this.modelL);
        this.carPanel1.add(this.modelTF);
        this.carPanel1.add(this.carTypeL);
        this.carPanel1.add(this.carTypeCombo);
        this.carPanel1.add(this.licencePlateL);
        this.carPanel1.add(this.licencePlateTF);
        this.carPanel1.add(this.priceL);
        this.carPanel1.add(this.priceTF);
        this.carPanel1.add(this.yearL);
        this.carPanel1.add(this.yearTF);
        this.carPanel1.add(this.colorL);
        this.carPanel1.add(this.colorTF);
        this.carPanel1.add(this.transmissionL);
        this.carPanel1.add(this.transmissionCombo);
        this.carPanel1.add(this.ownerL);
        this.carPanel1.add(this.comboOwner);
        this.carPanel.add(this.carPanel2);
        this.carPanel2.add(this.BAdd);
        this.carPanel2.add(this.BDel);
        this.carPanel2.add(this.BEdit);
        this.carPanel2.add(this.carSearch);
        this.carPanel2.add(this.carColourSearchTF);
        this.carColourSearchTF.setPreferredSize(new Dimension(200, 30));
        this.carPanel2.add(this.carSearchScroll);
        this.BAdd.addActionListener(new AddCarDB());
        this.BDel.addActionListener(new DelCarDB());
        this.BEdit.addActionListener(new EditCarDB());
        this.carSearch.addActionListener(new SearchCarDB());
        this.carPanel.add(this.carPanel3);
        this.carScroll.setPreferredSize(new Dimension(550, 200));
        this.carSearchScroll.setPreferredSize(new Dimension(550, 200));
        this.carPanel3.add(this.carScroll);
        this.tab.add(this.manPanel, "Производители");
        this.manPanel.setLayout(new GridLayout(3, 1));
        this.manPanel.add(this.manPanel1);
        this.manPanel1.setLayout(new GridLayout(2, 2));
        this.manPanel1.add(this.manNameL);
        this.manPanel1.add(this.manNameTF);
        this.manPanel1.add(this.manCountryL);
        this.manPanel1.add(this.manCountryTF);
        this.manPanel.add(this.manPanel2);
        this.manPanel2.add(this.manAdd);
        this.manPanel2.add(this.manDel);
        this.manPanel2.add(this.manEdit);
        this.manPanel2.add(this.manSearch);
        this.manPanel2.add(this.manSearchCountryTF);
        this.manSearchCountryTF.setPreferredSize(new Dimension(200, 30));
        this.manAdd.addActionListener(new AddManufacturerDB());
        this.manDel.addActionListener(new DelManufacturerDB());
        this.manEdit.addActionListener(new EditManufacturerDB());
        this.manSearch.addActionListener(new SearchManufacturerDB());
        this.manPanel2.add(this.manSearchScroll);
        this.manPanel.add(this.manPanel3);
        this.manScroll.setPreferredSize(new Dimension(550, 200));
        this.manSearchScroll.setPreferredSize(new Dimension(550, 200));
        this.manPanel3.add(this.manScroll);
        this.tab.add(this.ownerPanel, "Собственици");
        this.ownerPanel.setLayout(new GridLayout(3, 1));
        this.ownerPanel.add(this.ownerPanel1);
        this.ownerPanel1.setLayout(new GridLayout(4, 2));
        this.ownerPanel1.add(this.ownerFirstNameL);
        this.ownerPanel1.add(this.ownerFirstNameTF);
        this.ownerPanel1.add(this.ownerLastNameL);
        this.ownerPanel1.add(this.ownerLastNameTF);
        this.ownerPanel1.add(this.ownerPhoneNumberL);
        this.ownerPanel1.add(this.ownerPhoneNumberTF);
        this.ownerPanel1.add(this.ownerEmailL);
        this.ownerPanel1.add(this.ownerEmailTF);
        this.ownerPanel.add(this.ownerPanel2);
        this.ownerPanel2.add(this.ownerAdd);
        this.ownerPanel2.add(this.ownerDel);
        this.ownerPanel2.add(this.ownerEdit);
        this.ownerPanel2.add(this.ownerSearch);
        this.ownerPanel2.add(this.ownerSearchLastNameTF);
        this.ownerPanel2.add(this.ownerSearchScroll);
        this.ownerSearchLastNameTF.setPreferredSize(new Dimension(200, 30));
        this.ownerAdd.addActionListener(new AddOwnerDB());
        this.ownerDel.addActionListener(new DelOwnerDB());
        this.ownerEdit.addActionListener(new EditOwnerDB());
        this.ownerSearch.addActionListener(new SearchOwnerDB());
        this.ownerPanel.add(this.ownerPanel3);
        this.ownerSearchScroll.setPreferredSize(new Dimension(550, 200));
        this.ownerScroll.setPreferredSize(new Dimension(550, 200));
        this.ownerPanel3.add(this.ownerScroll);
        this.tab.add(this.sprPanel, "Справка");
        this.sprPanel.setLayout(new GridLayout(3, 1));
        this.sprPanel.add(this.sprPanel1);
        this.sprPanel1.add(this.sprCarYearL);
        this.sprPanel1.add(this.sprCarYearTF);
        this.sprPanel1.add(this.sprCarCountryL);
        this.sprPanel1.add(this.sprCarCountryTF);
        this.sprCarYearTF.setPreferredSize(new Dimension(450, 30));
        this.sprCarCountryTF.setPreferredSize(new Dimension(450, 30));
        this.sprPanel.add(this.sprPanel2);
        this.sprPanel2.add(this.sPrSearch);
        this.sPrSearch.addActionListener(new SearchDB());
        this.sprPanel.add(this.sprPanel3);
        this.sprScroll.setPreferredSize(new Dimension(550, 200));
        this.sprPanel3.add(this.sprScroll);
        this.add(this.tab);
        this.setVisible(true);
        this.refreshCarsTable();
        this.refreshComboMan();
        this.refreshComboOwner();
        this.refreshManTable();
        this.refreshOwnerTable();
        this.carTable.addMouseListener(new MouseActionCarTable());
        this.manTable.addMouseListener(new MouseActionManufacturerTable());
        this.ownerTable.addMouseListener(new MouseActionOwnerTable());
        this.comboManufacturer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (carsFrame.this.tab.getSelectedIndex() == 0 && carsFrame.this.idman > 0) {
                    String str = "select * from manufacturers where name='" + carsFrame.this.comboManufacturer.getSelectedItem().toString() + "'";

                    try {
                        carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                        carsFrame.this.result = carsFrame.this.state.executeQuery();
                        carsFrame.this.result.next();
                        carsFrame.this.idman = Integer.parseInt(carsFrame.this.result.getObject(1).toString());
                    } catch (SQLException var4) {
                        SQLException e1 = var4;
                        e1.printStackTrace();
                    }

                    System.out.println(carsFrame.this.comboManufacturer.getSelectedItem().toString());
                    System.out.println(str);
                    System.out.println(carsFrame.this.idman);
                }

            }
        });
        this.comboOwner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (carsFrame.this.tab.getSelectedIndex() == 0 && carsFrame.this.idown > 0) {
                    String str = "select * from owners where first_name='" + carsFrame.this.comboOwner.getSelectedItem().toString() + "'";

                    try {
                        carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                        carsFrame.this.result = carsFrame.this.state.executeQuery();
                        carsFrame.this.result.next();
                        carsFrame.this.idown = Integer.parseInt(carsFrame.this.result.getObject(1).toString());
                    } catch (SQLException var4) {
                        SQLException e1 = var4;
                        e1.printStackTrace();
                    }

                    System.out.println(carsFrame.this.comboOwner.getSelectedItem().toString());
                    System.out.println(str);
                    System.out.println(carsFrame.this.idown);
                }

            }
        });
    }

    public void refreshCarsTable() {
        String query = "SELECT id, manufacturer, model, car_type, licence_plate_number, year, color, price, transmission_type, owner FROM cars";
        try {
            state = conn.prepareStatement(query);
            result = state.executeQuery();

            carTable.setModel(new MyModel(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshManTable() {
        String str = "select id, name, country from manufacturers";

        try {
            state = conn.prepareStatement(str);
            result = state.executeQuery();

            manTable.setModel(new MyModel(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refreshOwnerTable() {
        String str = "select id, first_name, last_name, phone_number, email from owners";

        try {
            state = conn.prepareStatement(str);
            result = state.executeQuery();

            ownerTable.setModel(new MyModel(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refreshComboMan() {
        this.idman = -1;
        this.comboManufacturer.removeAllItems();
        String sql = "select id, name, country from manufacturers";
        String item = "";

        try {
            this.state = this.conn.prepareStatement(sql);
            this.result = this.state.executeQuery();
            if (this.result.next()) {
                this.idman = Integer.parseInt(this.result.getObject(1).toString());

                do {
                    item = this.result.getObject(2).toString();
                    this.comboManufacturer.addItem(item);
                } while (this.result.next());
            }
        } catch (SQLException var4) {
            SQLException e = var4;
            e.printStackTrace();
        }

    }

    public void refreshComboOwner() {
        this.idown = -1;
        this.comboOwner.removeAllItems();
        String sql = "select id, first_name, last_name, phone_number, email from owners";
        String item = "";

        try {
            this.state = this.conn.prepareStatement(sql);
            this.result = this.state.executeQuery();
            if (this.result.next()) {
                this.idown = Integer.parseInt(this.result.getObject(1).toString());

                do {
                    item = this.result.getObject(2).toString();
                    this.comboOwner.addItem(item);
                } while (this.result.next());
            }
        } catch (SQLException var4) {
            SQLException e = var4;
            e.printStackTrace();
        }

    }

    class AddCarDB implements ActionListener {
        AddCarDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.modelTF.getText().isEmpty()) {
                String sql = "insert into cars values(null,?,?,?,?,?,?,?,?,?)";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setInt(1, carsFrame.this.idman);
                    carsFrame.this.state.setString(2, modelTF.getText());
                    carsFrame.this.state.setString(3, carTypeCombo.getSelectedItem().toString());
                    carsFrame.this.state.setString(4, licencePlateTF.getText());
                    carsFrame.this.state.setInt(5, Integer.parseInt(yearTF.getText()));
                    carsFrame.this.state.setString(6, colorTF.getText());
                    carsFrame.this.state.setDouble(7, Double.parseDouble(priceTF.getText()));
                    carsFrame.this.state.setString(8, transmissionCombo.getSelectedItem().toString());
                    carsFrame.this.state.setInt(9, carsFrame.this.idown);
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshCarsTable();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.modelTF.setText("");
                carsFrame.this.licencePlateTF.setText("");
                carsFrame.this.colorTF.setText("");
                carsFrame.this.yearTF.setText("");
                carsFrame.this.priceTF.setText("");
                carsFrame.this.id = -1;
            }

        }
    }

    class AddOwnerDB implements ActionListener {
        AddOwnerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.ownerFirstNameTF.getText().isEmpty()) {
                String sql = "insert into owners values(null,?,?,?,?)";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.ownerFirstNameTF.getText());
                    carsFrame.this.state.setString(2, carsFrame.this.ownerLastNameTF.getText());
                    carsFrame.this.state.setString(3, carsFrame.this.ownerPhoneNumberTF.getText());
                    carsFrame.this.state.setString(4, carsFrame.this.ownerEmailTF.getText());
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshOwnerTable();
                    carsFrame.this.refreshComboOwner();


                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.ownerFirstNameTF.setText("");
                carsFrame.this.ownerLastNameTF.setText("");
                carsFrame.this.ownerPhoneNumberTF.setText("");
                carsFrame.this.ownerEmailTF.setText("");
            }

        }
    }

    class AddManufacturerDB implements ActionListener {
        AddManufacturerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.manNameTF.getText().isEmpty()) {
                String sql = "insert into manufacturers values(null,?,?)";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.manNameTF.getText());
                    carsFrame.this.state.setString(2, carsFrame.this.manCountryTF.getText());
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshManTable();
                    carsFrame.this.refreshComboMan();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.manNameTF.setText("");
                carsFrame.this.manCountryTF.setText("");
            }

        }
    }

    class DelCarDB implements ActionListener {
        DelCarDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            String sql = "delete from cars where licence_plate_number=?";

            try {
                carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                carsFrame.this.state.setString(1, carsFrame.this.licencePlateTF.getText());
                carsFrame.this.state.execute();
                carsFrame.this.refreshCarsTable();
            } catch (SQLException var4) {
                SQLException e1 = var4;
                e1.printStackTrace();
            }

            carsFrame.this.modelTF.setText("");
            carsFrame.this.colorTF.setText("");
            carsFrame.this.yearTF.setText("");
            carsFrame.this.licencePlateTF.setText("");
            carsFrame.this.priceTF.setText("");
            carsFrame.this.id = -1;


        }
    }

    class DelOwnerDB implements ActionListener {
        DelOwnerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (carsFrame.this.idown > 0) {
                String sql = "delete from owners where phone_number=?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.ownerPhoneNumberTF.getText());
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshOwnerTable();
                    carsFrame.this.refreshComboOwner();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.ownerFirstNameTF.setText("");
                carsFrame.this.ownerLastNameTF.setText("");
                carsFrame.this.ownerPhoneNumberTF.setText("");
                carsFrame.this.ownerEmailTF.setText("");
            }

        }
    }

    class DelManufacturerDB implements ActionListener {
        DelManufacturerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (carsFrame.this.idman > 0) {
                String sql = "delete from manufacturers where name=?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.manNameTF.getText());
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshManTable();
                    carsFrame.this.refreshComboMan();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.manNameTF.setText("");
                carsFrame.this.manCountryTF.setText("");
            }

        }
    }

    class EditCarDB implements ActionListener {
        EditCarDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (carsFrame.this.id > 0) {
                String sql = "update cars set manufacturer=?, model=?, car_type=?, licence_plate_number=?, year=?, color=?, price=?, transmission_type=?, owner =? where id=?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setInt(1, carsFrame.this.idman);
                    carsFrame.this.state.setString(2, carsFrame.this.modelTF.getText());
                    carsFrame.this.state.setString(3, carTypeCombo.getSelectedItem().toString());
                    carsFrame.this.state.setString(4, licencePlateTF.getText());
                    carsFrame.this.state.setInt(5, Integer.parseInt(yearTF.getText()));
                    carsFrame.this.state.setString(6, colorTF.getText());
                    carsFrame.this.state.setDouble(7, Double.parseDouble(priceTF.getText()));
                    carsFrame.this.state.setString(8, transmissionCombo.getSelectedItem().toString());
                    carsFrame.this.state.setInt(9, carsFrame.this.idown);
                    carsFrame.this.state.setInt(10, carsFrame.this.id);
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshCarsTable();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.modelTF.setText("");
                carsFrame.this.licencePlateTF.setText("");
                carsFrame.this.colorTF.setText("");
                carsFrame.this.yearTF.setText("");
                carsFrame.this.priceTF.setText("");
                carsFrame.this.id = -1;
            }
        }
    }

    class EditOwnerDB implements ActionListener {
        EditOwnerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (carsFrame.this.idown > 0) {
                String sql = "update owners set first_name=?, last_name=?, phone_number=?, email=? where id=?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.ownerFirstNameTF.getText());
                    carsFrame.this.state.setString(2, carsFrame.this.ownerLastNameTF.getText());
                    carsFrame.this.state.setString(3, carsFrame.this.ownerPhoneNumberTF.getText());
                    carsFrame.this.state.setString(4, carsFrame.this.ownerEmailTF.getText());
                    carsFrame.this.state.setInt(5, carsFrame.this.idown);
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshOwnerTable();
                    carsFrame.this.refreshComboOwner();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.ownerFirstNameTF.setText("");
                carsFrame.this.ownerLastNameTF.setText("");
                carsFrame.this.ownerPhoneNumberTF.setText("");
                carsFrame.this.ownerEmailTF.setText("");
            }

        }
    }

    class EditManufacturerDB implements ActionListener {
        EditManufacturerDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (carsFrame.this.idman > 0) {
                String sql = "update manufacturers set name=?, country=? WHERE id=?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(sql);
                    carsFrame.this.state.setString(1, carsFrame.this.manNameTF.getText());
                    carsFrame.this.state.setString(2, carsFrame.this.manCountryTF.getText());
                    carsFrame.this.state.setInt(3, carsFrame.this.idman);
                    carsFrame.this.state.execute();
                    carsFrame.this.refreshManTable();
                    carsFrame.this.refreshComboMan();
                } catch (SQLException var4) {
                    SQLException e1 = var4;
                    e1.printStackTrace();
                }

                carsFrame.this.manNameTF.setText("");
                carsFrame.this.manCountryTF.setText("");
            }

        }
    }
    class SearchCarDB implements ActionListener {
        SearchCarDB() {}
        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.carColourSearchTF.getText().isEmpty()) {
                String str = "SELECT * FROM cars WHERE color = ?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                    carsFrame.this.state.setString(1,carsFrame.this.carColourSearchTF.getText());
                    carsFrame.this.result = carsFrame.this.state.executeQuery();
                    carsFrame.this.carSearchTable.setModel(new MyModel(carsFrame.this.result));

                } catch (SQLException var4) {
                    var4.printStackTrace();
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                carsFrame.this.carColourSearchTF.setText("");
            }
        }
    }

    class SearchManufacturerDB implements ActionListener {
        SearchManufacturerDB() {}
        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.manSearchCountryTF.getText().isEmpty()) {
                String str = "SELECT * FROM manufacturers WHERE country = ?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                    carsFrame.this.state.setString(1,carsFrame.this.manSearchCountryTF.getText());
                    carsFrame.this.result = carsFrame.this.state.executeQuery();
                    carsFrame.this.manSearchTable.setModel(new MyModel(carsFrame.this.result));

                } catch (SQLException var4) {
                    var4.printStackTrace();
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                carsFrame.this.manSearchCountryTF.setText("");
            }
        }
    }

    class SearchOwnerDB implements ActionListener {
        SearchOwnerDB() {}
        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.ownerSearchLastNameTF.getText().isEmpty()) {
                String str = "SELECT * FROM owners WHERE last_name = ?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                    carsFrame.this.state.setString(1,carsFrame.this.ownerSearchLastNameTF.getText());
                    carsFrame.this.result = carsFrame.this.state.executeQuery();
                    carsFrame.this.ownerSearchTable.setModel(new MyModel(carsFrame.this.result));

                } catch (SQLException var4) {
                    var4.printStackTrace();
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                carsFrame.this.ownerSearchLastNameTF.setText("");
            }
        }
    }

    class MouseActionCarTable implements MouseListener {
        MouseActionCarTable() {
        }

        public void mouseClicked(MouseEvent e) {
            int row = carsFrame.this.carTable.getSelectedRow();
            carsFrame.this.modelTF.setText(carsFrame.this.carTable.getValueAt(row, 2).toString());
            carsFrame.this.carTypeCombo.setSelectedItem(carsFrame.this.carTable.getValueAt(row, 3).toString());
            carsFrame.this.licencePlateTF.setText(carsFrame.this.carTable.getValueAt(row, 4).toString());
            carsFrame.this.yearTF.setText(carsFrame.this.carTable.getValueAt(row, 5).toString());
            carsFrame.this.colorTF.setText(carsFrame.this.carTable.getValueAt(row, 6).toString());
            carsFrame.this.priceTF.setText(carsFrame.this.carTable.getValueAt(row, 7).toString());
            carsFrame.this.transmissionCombo.setSelectedItem(carsFrame.this.carTable.getValueAt(row, 8).toString());
            carsFrame.this.comboManufacturer.setSelectedItem(carsFrame.this.carTable.getValueAt(row, 1).toString());
            carsFrame.this.comboOwner.setSelectedItem(carsFrame.this.carTable.getValueAt(row, 9).toString());
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    class MouseActionOwnerTable implements MouseListener {
        MouseActionOwnerTable() {
        }

        public void mouseClicked(MouseEvent e) {
            int row = carsFrame.this.ownerTable.getSelectedRow();
            carsFrame.this.idown = Integer.parseInt(carsFrame.this.ownerTable.getValueAt(row, 0).toString());
            carsFrame.this.ownerFirstNameTF.setText(carsFrame.this.ownerTable.getValueAt(row, 1).toString());
            carsFrame.this.ownerLastNameTF.setText(carsFrame.this.ownerTable.getValueAt(row, 2).toString());
            carsFrame.this.ownerPhoneNumberTF.setText(carsFrame.this.ownerTable.getValueAt(row, 3).toString());
            carsFrame.this.ownerEmailTF.setText(carsFrame.this.ownerTable.getValueAt(row, 4).toString());
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    class MouseActionManufacturerTable implements MouseListener {
        MouseActionManufacturerTable() {
        }

        public void mouseClicked(MouseEvent e) {
            int row = carsFrame.this.manTable.getSelectedRow();
            carsFrame.this.idman = Integer.parseInt(carsFrame.this.manTable.getValueAt(row, 0).toString());
            carsFrame.this.manNameTF.setText(carsFrame.this.manTable.getValueAt(row, 1).toString());
            carsFrame.this.manCountryTF.setText(carsFrame.this.manTable.getValueAt(row, 2).toString());
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    class SearchDB implements ActionListener {
        SearchDB() {
        }

        public void actionPerformed(ActionEvent arg0) {
            if (!carsFrame.this.sprCarYearTF.getText().isEmpty() && Double.parseDouble(carsFrame.this.sprCarYearTF.getText()) > 1886 && !carsFrame.this.sprCarCountryTF.getText().isEmpty()) {
                String str = "SELECT cars.model, manufacturers.name AS manufacturer, manufacturers.country AS manufacturer_country, cars.year, cars.price, cars.color, cars.transmission_type, owners.first_name, owners.last_name, owners.phone_number, owners.email FROM cars INNER JOIN manufacturers ON cars.manufacturer = manufacturers.id INNER JOIN owners ON cars.owner = owners.id WHERE cars.year <= ? AND manufacturers.country = ?";

                try {
                    carsFrame.this.state = carsFrame.this.conn.prepareStatement(str);
                    carsFrame.this.state.setInt(1, Integer.parseInt(carsFrame.this.sprCarYearTF.getText()));
                    carsFrame.this.state.setString(2, carsFrame.this.sprCarCountryTF.getText());
                    carsFrame.this.result = carsFrame.this.state.executeQuery();
                    carsFrame.this.sprTable.setModel(new MyModel(carsFrame.this.result));
                    carsFrame.this.sprTable.getColumnModel().getColumn(3).setMinWidth(0);
                    carsFrame.this.sprTable.getColumnModel().getColumn(3).setMaxWidth(0);
                    carsFrame.this.sprTable.getColumnModel().getColumn(3).setWidth(0);
                    carsFrame.this.sprTable.getColumnModel().getColumn(5).setMinWidth(0);
                    carsFrame.this.sprTable.getColumnModel().getColumn(5).setMaxWidth(0);
                    carsFrame.this.sprTable.getColumnModel().getColumn(5).setWidth(0);
                } catch (SQLException var4) {
                    var4.printStackTrace();
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

                carsFrame.this.sprCarYearTF.setText("");
                carsFrame.this.sprCarCountryTF.setText("");
            }

        }
    }
}

