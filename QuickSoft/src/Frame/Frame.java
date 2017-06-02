/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package Frame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import static javafx.geometry.HPos.RIGHT;

import java.io.File;
import java.io.IOException;

import Mains.Init;
import Mains.quickSort;
import Mains.sort;
import Utils.baseUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
//        grid.setColumnSpan(actiontarget, 2);
//        grid.setHalignment(actiontarget, RIGHT);
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
//                	//显示进度条
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
        	sort  s = new sort();
        	int[] v = baseUtils.read2Array(userTextField.getText());
//        	qs.qSort(v);
        	s.qSort(v);
        	try {
				String url = baseUtils.save2File(v);
                actiontarget.setText("排序成功！\n" + "路径：" + url);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
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