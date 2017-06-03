package Frame;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import DB.DataOperation;
import Mains.Init;
import Mains.quickSort;
import Utils.baseUtils;
import entity.Entity;
import entity.ReadEntity;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.security.util.Length;

/**
 * 框架类
 * @author 罗渊
 *
 * 2017年6月1日
 */
public class Frame extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("快速排序小程序 ");
        primaryStage.setResizable(false);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 0, 10);
        actiontarget.setId("actiontarget");
        Text scenetitle = new Text("快速排序");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        Button btn = new Button("生成用例");
        Button btn2 = new Button("选择用例");
        Button btn3 = new Button("排序");
        Button btn5 = new Button("结果分析");
        grid.add(btn3, 3, 1);
        
        btn.setOnAction((ActionEvent e) -> {
        	Stage stage=new Stage();
        	stage.setTitle("新增一个用例");
        	stage.setWidth(400);
        	stage.setHeight(250);
        	stage.setResizable(false);
        	GridPane gp = new GridPane();
        	TextField tf = new TextField(); 
        	Button btn4 = new Button("确定");
        	
        	//添加三个按钮
            RadioButton rb1 = new RadioButton("随机用例");  
            RadioButton rb2 = new RadioButton("升序");   
            RadioButton rb3 = new RadioButton("降序");   
            RadioButton rb4 = new RadioButton("重复");   
            
            ToggleGroup group = new ToggleGroup();   
            rb1.setStyle("-fx-base: lightgreen;");
            rb2.setStyle("-fx-base: lightblue;");
            rb3.setStyle("-fx-base: salmon;");
            rb4.setStyle("-fx-base: lightgreen;");
            rb1.setToggleGroup(group);   
            rb1.setSelected(true);   
            rb2.setToggleGroup(group);   
            rb3.setToggleGroup(group); 
            rb4.setToggleGroup(group); 
            
            gp.setHgap(2);
            gp.setVgap(1);
            gp.setPadding(new Insets(30, 25, 30, 25));
            gp.add(tf, 4, 12);
        	gp.add(btn4, 10, 12);
            gp.add(rb1,4,80);
            gp.add(rb2,5,80);
            gp.add(rb3,10,80);
            gp.add(rb4,15,80);
        	Scene sc = new Scene(gp);
        	sc.getStylesheets().add(Frame.class.getResource("second.css").toExternalForm());
        	stage.setScene(sc);
        	stage.show();
        	
        	btn4.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                	//显示进度条
                    ProgressBar pb = new ProgressBar(0.6);  
                	sc.setRoot(pb);
                	
                	//输出路径
                	String output = Init.creatRandomText(Integer.parseInt(tf.getText()));
                    actiontarget.setText(output);
                    stage.close();
                }
                
            });
        });  
        
        btn2.setOnAction((ActionEvent e) -> {  
        	FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter(
                    "txt files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(csvFilter);
            File file = fileChooser.showOpenDialog(new Stage());
            userTextField.setText(file.getAbsoluteFile().toString());
            System.out.println(file.getAbsoluteFile());
        }); 
        
        btn3.setOnAction((ActionEvent e) -> {  
        	System.out.println(userTextField.getText());
        	quickSort qs = new quickSort();

        	//测试
        	int[] v = baseUtils.read2Array(userTextField.getText());
        	long currentTime1 = System.nanoTime();
        	qs.qSort(v,0,v.length-1);
        	long currentTime2 = System.nanoTime();
        	double time = baseUtils.nanoTime2MillsTime(currentTime2-currentTime1);
        	String type = "1";
        	DataOperation.saveEntity(type, v.length, time);
        	try {
				String url = baseUtils.save2File(v);
                actiontarget.setText("排序成功！\n" + "路径：" + url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });  
       
        //结果分析-->输出一个表格显示数据
        btn5.setOnAction((ActionEvent e) -> {  
        	Stage stage=new Stage();
        	stage.setTitle("新增一个用例");
        	stage.setWidth(450);
        	stage.setHeight(500);
        	stage.setResizable(false);
        	TableView table = new TableView();  
            Scene scene = new Scene(new Group());   
            final Label label = new Label("结果分析");  
            label.setFont(new Font("Microsoft YaHei", 20));  
            table.setEditable(true);  
            
            //添加数据
            final ObservableList<ReadEntity> data =  
                    FXCollections.observableArrayList(  
                     
            );  
            
            TableColumn NameCol1 = new TableColumn("用例类型");  
            NameCol1.setMinWidth(100); 
            NameCol1.setCellValueFactory(  
                    new PropertyValueFactory<>("type")  
            );
            TableColumn NameCol2 = new TableColumn("大小");  
            NameCol2.setMinWidth(100);  
            NameCol2.setCellValueFactory(  
                    new PropertyValueFactory<>("size")  
            );
            TableColumn NameCol3 = new TableColumn("用时");  
            NameCol3.setMinWidth(200);  
            NameCol3.setCellValueFactory(  
                    new PropertyValueFactory<>("time")  
            );
            
            List<Entity> list = DataOperation.serachFromDB();
            Iterator<Entity> it = list.iterator();
            while(it.hasNext()) {
            	Entity t = it.next();
            	data.add(new ReadEntity(t.getType(), Integer.toString(t.getSize()), Double.toString(t.getTime())+"ms"));
            }
            
            table.setItems(data);  
            table.getColumns().addAll(NameCol1, NameCol2, NameCol3);  
            final VBox vbox = new VBox();  
            vbox.setSpacing(5);  
            vbox.setPadding(new Insets(10, 0, 0, 10));
            vbox.getChildren().addAll(label, table);  
            ((Group) scene.getRoot()).getChildren().addAll(vbox);  
            stage.setScene(scene);  
            stage.show();  
        }); 
		
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_LEFT);
        hbBtn.getChildren().add(btn);
        hbBtn.getChildren().add(btn2);
        hbBtn.getChildren().add(btn5);
        grid.add(hbBtn, 1, 4);

        Scene scene = new Scene(grid, 700, 550);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Frame.class.getResource("frame.css").toExternalForm());
        primaryStage.show();
    }
    
       public static void main(String[] args) {
        launch(args);
    }

}