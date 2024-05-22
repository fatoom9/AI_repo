
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
//import javafx.scene.control.RadioButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class GUI_MAIN extends javax.swing.JFrame {

    int x, y; //point coordinate
    
 private double alpha;//learning rate
 
  public static double w01, w11, w21, w02, w12, w22, w03, w13, w23, w04, w14, w24;//wights

    public static int p1x, p2x, p1y, p2y; //lines
    
    public static int p11y, p21y;
    //////
    public static int p12y, p22y;
    ////
    public static int p13y, p23y;
    public static int p14y, p24y;

    public int[][] yCalc = {{0, 0}, {0, 0}, {0, 0}, {0, 0}};
    /////
    public double[][] wights = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

   
    boolean f = false;
    private int max_itr;
    double w1, w2, th;
    int count = 1;
    double x0 = -1;
   
    private int classFlag = -1;
    ArrayList<data_points> points, pc1, pc2, pc3, pc4;//lists for store points acoording classes
    private double w0 = -1;//theta
    HashSet set;//to store classes
    private int classCount = 0;
    ArrayList<ArrayList<data_points>> Clist; //to store point as class , add pc1....

    int sse = 100;//sum square error
    
    /**
     *
     */
    public GUI_MAIN() {
        
        points = new ArrayList<>();
        pc1 = new ArrayList<>();//array for each class
        pc2 = new ArrayList<>();
        pc3 = new ArrayList<>();
        pc4 = new ArrayList<>();
        Clist = new ArrayList<>(4); // array

        initComponents();
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);

        Clist.add(pc1);
        Clist.add(pc2);
        Clist.add(pc3);
        Clist.add(pc4);

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setText("Classify");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("x1");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("x2");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jPanel3 = new javax.swing.JPanel() {

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(jPanel3.getWidth()/2,0, jPanel3.getWidth()/2, jPanel3.getHeight());
                g.drawLine(0,jPanel3.getHeight()/2, jPanel3.getWidth(), jPanel3.getHeight()/2);

                //        Graphics2D g2 = (Graphics2D) g;
                //        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                //        g2.setColor(Color.red);
                //        for (Point point : points) {
                    //if(jRadioButton2.isSelected())
                    //            g2.fillOval(point.x, point.y, 5, 5);
                    //        }

                //
                //    if(mustDraw && jRadioButton1.isSelected())
                //{ Graphics2D g2 = (Graphics2D) g;
                    //    g2.setColor(Color.red);
                    //    g2.fillOval(x, y, 10, 10);}

            };

        };
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(260, 260));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 287, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Class 1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Class 2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Class 3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Class 4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Maximum number of ittirations :");

        jTextField1.setText("100");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Learning rate :");

        jSlider1.setBackground(new java.awt.Color(51, 0, 0));
        jSlider1.setMajorTickSpacing(50);
        jSlider1.setMaximum(50);
        jSlider1.setMinorTickSpacing(2);
        jSlider1.setPaintTicks(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 51));
        jButton4.setText("Learn ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setText("Performance");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 263, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jRadioButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jRadioButton2)
                        .addGap(36, 36, 36)
                        .addComponent(jRadioButton3)
                        .addGap(34, 34, 34)
                        .addComponent(jRadioButton4)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(23, 23, 23)
                        .addComponent(jButton3)
                        .addGap(20, 20, 20)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        classFlag = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        if (classFlag > 0) {
            x = evt.getX();
            y = evt.getY();
            drawCircle(x, y);
        }
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //clear
    
        repaint();//reagain 
        points.clear();
        pc1.clear();
        pc2.clear();
        pc3.clear();
        pc4.clear();
        //Clist.clear();
        classCount = 0;
        jButton3.setEnabled(false);//prf
        jButton5.setEnabled(false);//classi
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        classFlag = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        classFlag = 3;
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        classFlag = 4;
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        jLabel2.setText("Learning Rate :" + (double) jSlider1.getValue() / 100);
    }//GEN-LAST:event_jSlider1StateChanged

   


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
    //show performance
    
     System_Performance p = new System_Performance(points, wights, wights, set);

        p.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
  
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
        
//learning
        
        count = 1;
        classCount = getNumOfClasses(points); // 
        
        int linee = 0;
        for (int i = 1; i <= 4; i++) {
            if (set.contains(i)) {// if hashset contain label
                if(classCount < 2){
            JOptionPane.showMessageDialog(rootPane, "Please use at least two types of classes", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                if (classCount == 2 && linee == 1) {
                    break; 
                }
                sse = 100;
                getTrainingSets(Clist.get(i - 1), i);//clist is array of class1,2,3,4.
                classificat(Clist.get(i - 1), i); //i is num class
                linee++;
            }
        }
       //JOptionPane.showMessageDialog(rootPane, sse, "SSE", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

   //classify     
        
        if (jTextField2.getText().equals("") || jTextField3.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter data first", "", JOptionPane.WARNING_MESSAGE);
        } else {
            
            double x1 = Double.parseDouble(jTextField2.getText());
            double x2 = Double.parseDouble(jTextField3.getText());
            if(!(-10.0 <= x1 && x1 <= 10.0) || !(-10.0 <= x2 && x2 <= 10.0))
                JOptionPane.showMessageDialog(this, "Data set range is ]-10,10[", "", JOptionPane.WARNING_MESSAGE);
            else{
//            int[] myNum = {10, 20, 30, 40};
            double[] yam = {0, 0, 0, 0}; //for multi ,  to store the weighted sums for multi-class classification. Each element of yam corresponds to a different class
            int  class_label = -1;
            double max = 0;

            Integer[] class2 = (Integer[]) set.toArray(new Integer[set.size()]);

            class_label = 0;
            max = 0;
            double ws = 0;
            count = 0;
            for (int i = 1; i <= 4; i++) {

                if (set.contains(i)) {
                    if (set.size() == 2) {
                        if (count >= 1) { //  binary classification is completed after finding the first valid class label
                           break;
                        }
                      
//binary
                        ws = ((x1 * wights[i - 1][1]) + (x2 * wights[i - 1][2]) - (-1 * wights[i - 1][0])); //  computes the weighted sum
               
                        if (ws > 0) {
                         

                            class_label= i;
                        } else {
                         

                            if (Arrays.asList(class2).indexOf(i) == 0) {
                                 class_label = class2[1];//2
                            } else {
                                class_label = class2[0];//1
                            }
                        }

                        count++;
                         // JOptionPane.showMessageDialog(this, "[" + x1 + "," + x2 + "] data is " +  class_label, "classification region ", JOptionPane.PLAIN_MESSAGE);
            

                    } else { //multi
                        
                        yam[i - 1] = ((x1 * wights[i - 1][1]) + (x2 * wights[i - 1][2]) - (-1 * wights[i - 1][0]));
                   //using the maximum weighted sum computed for each class in the loop.
                        if (yam[i - 1] > max) {
                            max = yam[i - 1];
                             class_label = i;

                        }

                    }
                }
            }

            JOptionPane.showMessageDialog(this, "[" + x1 + "," + x2 + "] data  is classifide as class " +  class_label, "classification region ", JOptionPane.PLAIN_MESSAGE);
            

            x2 = (int) ((jPanel3.getHeight() / 2) - x2 * 13);
            x1 = (int) (x1 * 13 + (jPanel3.getHeight() / 2));


            Graphics g = jPanel3.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.drawOval((int) x1, (int) x2, 5, 5);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.RED);
            
            g2.fillOval((int) x1, (int) x2, 5, 5);
        }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

     private void classificationLine(ArrayList<data_points> point, int lable) {//draw lines based w1,w2,tHresHod

        double x1;

        x1 = -10;
        double yy = -(x1 * w1 / w2) - ((x0 * w0) / w2);



        p1y = (int) ((jPanel3.getHeight() / 2) - yy * 13);

        x1 = 10;
        double y2 = -(x1 * w1 / w2) - ((x0 * w0) / w2);
    
        p2y = (int) ((jPanel3.getHeight() / 2) - y2 * 13);

        if (w2 != 0) {
            switch (lable) {
                case 1:
                    yCalc[0][0] = p1y;
                    yCalc[0][1] = p2y;

                    
                    wights[0][0] = w0;
                    wights[0][1] = w1;
                    wights[0][2] = w2;

                    break;
                case 2:

                    yCalc[1][0] = p1y;
                    yCalc[1][1] = p2y;

                    wights[1][0] = w0;
                    wights[1][1] = w1;
                    wights[1][2] = w2;

                    break;
                case 3:


                    yCalc[2][0] = p1y;
                    yCalc[2][1] = p2y;

                    wights[2][0] = w0;
                    wights[2][1] = w1;
                    wights[2][2] = w2;
                    break;
                case 4:

                    yCalc[3][0] = p1y;
                    yCalc[3][1] = p2y;

                    wights[3][0] = w0;
                    wights[3][1] = w1;
                    wights[3][2] = w2;
                    break;
            }
            Graphics g = jPanel3.getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, jPanel3.getWidth(), jPanel3.getHeight());
            g2.setColor(Color.black);

            g2.drawLine(jPanel3.getWidth() / 2, 0, jPanel3.getWidth() / 2, jPanel3.getHeight());
            g2.drawLine(0, jPanel3.getHeight() / 2, jPanel3.getWidth(), jPanel3.getHeight() / 2);
            g2.setColor(Color.orange);

         
            int linee = 0;
            for (int i = 1; i <= 4; i++) {
                if (set.contains(i)) {//all class
                    if (classCount == 2 && linee == 1) {
                   //to draw one line
                  
                        break;
                    }

                    g2.setColor(Color.red);
                    g2.drawLine(0, yCalc[i - 1][0], jPanel3.getWidth(), yCalc[i - 1][1]);

                    linee++;
                }
            }


            redrawPoints(point);

        }
    }
    
    public int getNumOfClasses(ArrayList<data_points> points) { // to calculates  number of unique classes present in a given list of data points
        set = new HashSet();//store it in set (store unique class labels)

        for (data_points point : points) {
            set.add(point.getLable());
        }
        return set.size();//epresents the number of unique classes present in the data set

    }

    public void classificat(ArrayList<data_points> arr, int lable) {

        int i;
        int itr = 0;
    
        max_itr = Integer.parseInt(jTextField1.getText());
        alpha = (double) jSlider1.getValue() / 100;

        w1 = Math.random()-0.5;
        w2 = Math.random()-0.5;
        w0 = Math.random()-0.5;//theta

        while (sse != 0 && itr < max_itr) {
            //Epoch 
            int se = 0;
            for (i = 0; i <= arr.size() - 1; i++) {
                double x1 = arr.get(i).getX();
                double x2 = arr.get(i).getY();
                int ya;

                //activation step function
     /////////////////////////////////////////////////////
                if (((w1 * x1) + (w2 * x2) - w0) < 0) {
                    ya = 0;
                } else {
                    ya = 1;
                }
                

                if (ya != arr.get(i).getclass()) {
              
                    se += Math.pow(arr.get(i).getclass() - ya, 2);
                    w0 = w0 + alpha * (arr.get(i).getclass() - ya) * x0;
                    w1 = w1 + alpha * (arr.get(i).getclass() - ya) * x1;
                    w2 = w2 + alpha * (arr.get(i).getclass() - ya) * x2;
                }
              //  JOptionPane.showMessageDialog(rootPane, ya, "ya", JOptionPane.INFORMATION_MESSAGE);

 //JOptionPane.showMessageDialog(rootPane, arr.get(i).getclass(), "yd", JOptionPane.INFORMATION_MESSAGE);
            }

            classificationLine(arr, lable);
            sse = se;

      
            count++;
            itr++;
        }

        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
       // JOptionPane.showMessageDialog(rootPane, sse, "SSE", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getTrainingSets(ArrayList<data_points> arr, int lable) {//calculate yd عملة مقارنه لل labels 

//to save all points of class to array 
        for (data_points p : points) {
           data_points pc = new data_points();
            pc.copy(p);
            if (pc.getLable() == lable) {
                pc.setClass(1);
            } else {
                pc.setClass(0);
            }
            arr.add(pc);
        }
        
    }
// // to draw points in board and store it in list   
    public void drawCircle(double x, double y) {

        Graphics g = jPanel3.getGraphics();//whigt board
        
        Graphics2D g2 = (Graphics2D) g; // This line casts the Graphics object to Graphics2D, which provides more advanced drawing capabilities
        g2.drawOval((int) x, (int) y, 5, 5);
        g2.drawOval((int) x, (int) y, 5, 5);
      
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //This line sets rendering hints to improve the quality of the graphics by enabling antialiasing
        
        double posX = (double) (x - jPanel3.getWidth() / 2) / 13;//This line calculates the normalized x-coordinate of the point relative to the center of jPanel3 and scales it down by 13
  
        double posY = (double) ( jPanel3.getHeight() / 2 - y ) / 13; //تقليل حجم النطاق وجعله مناسبًا للاستخدام
        
      data_points p = new data_points(posX, posY); //representing a data point with coordinates (posX, posY)
        switch (classFlag) {
            case 1:
                g2.setColor(Color.BLUE);
                p.setColor(Color.BLUE);
                p.setLable(1); 

                break;
            case 2:
                g2.setColor(Color.black);
                p.setColor(Color.black);
                p.setLable(2);


                break;
            case 3:
                g2.setColor(Color.MAGENTA);
                p.setColor(Color.MAGENTA);
                p.setLable(3);

                break;

            case 4:
                g2.setColor(Color.YELLOW);
                p.setColor(Color.YELLOW);
                p.setLable(4);


                break;
        }
        p.setXP((int) x);
        p.setYP((int) y);
        points.add(p);
        g2.fillOval((int) x, (int) y, 5, 5);//to draw point in board g2
    }
//برجع يرسم كل النقاط من قائمة point ا 
    void redrawPoints(ArrayList<data_points> points) {
        Graphics g = jPanel3.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        for (data_points p : points) {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(p.getColor());
            g2.drawOval((int) p.getXP(), (int) p.getYP(), 5, 5);
            g2.fillOval((int) p.getXP(), (int) p.getYP(), 5, 5);

        }
    }

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MAIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
