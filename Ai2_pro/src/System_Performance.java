import java.awt.GridLayout;

import java.util.ArrayList;

import java.util.Arrays;


import java.awt.Color;
import java.awt.Font;


import javax.swing.JButton;
import java.util.HashSet;
import java.util.List;
public class System_Performance extends javax.swing.JFrame {

  //instance variables   
 float f;
    float p;
    float ac;//accu

    
     //constructor to initilaize GUI comp
    public System_Performance() {
        initComponents();
    }
// constructor for data 
    public System_Performance(ArrayList<data_points> point, double[][] y, double[][] w, HashSet set) {
           Integer[] mul = (Integer[]) set.toArray(new Integer[set.size()]);  //convert to int 

        Integer[] classes = (Integer[]) set.toArray(new Integer[set.size()]); // copy to anaot arr
               
        double[] arr = {0, 0, 0, 0}; //array of lengt 4
        int maxi = -1;
        double max = 0;
        int count;
        for (int m = 0; m <= point.size() - 1; m++) {
            Arrays.fill(arr , 0);
            maxi = 0;
            max = 0;
            double Yactual = 0;
            count = 0;
            //System.out.println("for point" + m);
            for (int i = 1; i <= 4; i++) {

                if (set.contains(i)) {
                    if (set.size() == 2) { //Handles binary classification case when there are only 2 classes in the dataset.

                        if (count >= 1) {
                            break;
                        }
                        

      Yactual = ((point.get(m).getX() * w[i - 1][1]) + (point.get(m).getY() * w[i - 1][2]) - (-1 * w[i - 1][0])); //y actual 
                     
                        if (Yactual > 0) {
                         

                            point.get(m).setClass(i);
                        } else { //Multi-Class Classification 
                            

                            if (Arrays.asList(classes).indexOf(i) == 0) {
                                point.get(m).setClass(classes[1]);
                            } else {
                                point.get(m).setClass(classes[0]);
                            }
                        }

                        count++;
                    } else {
    arr[i - 1] = (point.get(m).getX() * w[i - 1][1]) + (point.get(m).getY() * w[i - 1][2]) - (-1 * w[i - 1][0]);
                   
                      
                       
                        point.get(m).setClass(maxi);
                        if (arr[i - 1] > max) {
                            max = arr[i - 1];
                            maxi = i;

                        }
                        point.get(m).setClass(maxi);
                    }
                }
            }
         

        }


        initComponents();

        int val = set.size() + 1;
        JButton[][] b = new JButton[val][val];
        jPanel1.setLayout(new GridLayout(val, val));

        for (int i = 0; i < val; i++) {
            for (int j = 0; j < val; j++) {
                b[i][j] = new JButton("");
                b[i][j].setBackground(new Color(0xe4e3e3));
                    if(i==j) b[i][j].setBackground(new Color(0xb1d6de));//green

                jPanel1.add(b[i][j]);

            }

        }
                  
 
            List<Integer> Category = Arrays.asList(mul);
            


    int [][] confMatrix = new int[set.size()][set.size()];
    for (data_points inst : point ) {
          int outLabel = inst.getLable();
          int actualLabel = inst.getclass();
          int outLabelIndex = Category.indexOf(outLabel);
          int actualLabelIndex =    Category.indexOf(actualLabel);
          confMatrix[actualLabelIndex][outLabelIndex] += 1;
    }
    
    System.out.println(Arrays.deepToString(confMatrix));
        
        for (int z = 1; z<= set.size(); z++) {

          
           b[z][0].setText("(actual) Class " + mul[z - 1]);
            b[0][z].setText(" Class " + mul[z - 1]);                
        }
             for (int i = 0; i < val-1; i++) {
            for (int j = 0; j < val-1; j++) {
                
          // 
          b[i+1][j+1].setText(""+confMatrix[i][j]);    
            }}   
        b[0][0].setText("" + point.size());
    
          
           for(int k=0; k< val-1;k++){
               
            for(int n=0;n<val-1;n++){
             
            
              f += confMatrix[k][n];
              
               if(k==n){
               p +=confMatrix[k][n];
               }           
            }
                }
          ac=(float) ((p/f )*100.0); // calculate accurcy 
            System.out.println(p);
             System.out.println(f);
           System.out.println(ac);
           AccText.setText(ac+"%");  
    }
    
 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AccText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        AccText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccTextActionPerformed(evt);
            }
        });

        jLabel1.setText("Accuracy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(AccText, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AccText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccTextActionPerformed
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_AccTextActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new System_Performance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AccText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
