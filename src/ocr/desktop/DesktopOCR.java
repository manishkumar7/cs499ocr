/*
 * DesktopOCR.java
 *
 * Created on Sep 12, 2011, 5:45:32 PM
 */

package ocr.desktop;

import java.awt.Image;
import ocr.service.OpticalCharacterRecognizer;
import ocr.service.Trainer;
import ocr.system.ImageRetriever;

/**
 * Run the OCR program for the desktop user.
 *
 * @author Devin
 */
public class DesktopOCR extends javax.swing.JFrame
{

    /** Creates new form DesktopOCR */
    public DesktopOCR()
    {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      mOcrButton = new javax.swing.JButton();
      mTrainButton = new javax.swing.JButton();
      mImagePathTextField = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      jScrollPane2 = new javax.swing.JScrollPane();
      jScrollPane1 = new javax.swing.JScrollPane();
      mTextArea = new javax.swing.JTextArea();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      mOcrButton.setText("OCR");
      mOcrButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mOcrButtonActionPerformed(evt);
         }
      });

      mTrainButton.setText("Train");
      mTrainButton.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mTrainButtonActionPerformed(evt);
         }
      });

      mImagePathTextField.setText("C:\\test.jpg");

      jLabel1.setText("Image location:");

      mTextArea.setColumns(20);
      mTextArea.setRows(5);
      jScrollPane1.setViewportView(mTextArea);

      jScrollPane2.setViewportView(jScrollPane1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap())
               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(mImagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addGap(18, 18, 18)
                     .addComponent(mOcrButton)
                     .addGap(18, 18, 18)
                     .addComponent(mTrainButton))
                  .addGroup(layout.createSequentialGroup()
                     .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addContainerGap(418, Short.MAX_VALUE)))))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(mImagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(mOcrButton)
               .addComponent(mTrainButton))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void mOcrButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mOcrButtonActionPerformed
    {//GEN-HEADEREND:event_mOcrButtonActionPerformed
       mTextArea.setText(OpticalCharacterRecognizer.extractString(
          retrieveImage()));
    }//GEN-LAST:event_mOcrButtonActionPerformed

    private void mTrainButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_mTrainButtonActionPerformed
    {//GEN-HEADEREND:event_mTrainButtonActionPerformed
       mTextArea.setText(new Trainer(new DesktopPrompter(), retrieveImage()).
          train());
    }//GEN-LAST:event_mTrainButtonActionPerformed

    /**
     * Retrieve the image at the file path entered by the user
     *
     * @return The image at the location given by the user
     */
    private Image retrieveImage()
    {
       return new ImageRetriever(mImagePathTextField.getText()).readImage();
    }

    /**
    * Run the OCR program for the desktop user.
    *
    * @param args the command line arguments
    */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                new DesktopOCR().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel jLabel1;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTextField mImagePathTextField;
   private javax.swing.JButton mOcrButton;
   private javax.swing.JTextArea mTextArea;
   private javax.swing.JButton mTrainButton;
   // End of variables declaration//GEN-END:variables

}
