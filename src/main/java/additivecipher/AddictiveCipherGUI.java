package additivecipher;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

final class AddictiveCipherGUI extends JFrame {

    private JRadioButton a3RadioButton;
    private JRadioButton a4RadioButton;
    private JTextField tfMessage;
    private JButton btnDecipher;
    private JTextField tfDecipheredMessage;
    private JPanel mainPanel;

    private String originalMessage;
    private final StringBuilder decipherMessage = new StringBuilder();
    private final int MAX_ALPHABET_INDEX = 26;
    private final List<Character> ALPHABET = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    public AddictiveCipherGUI() {
        groupRadioButton();
        setTitle("CryptoAnalysis: Addictive Cipher");
        setContentPane(mainPanel);
        setVisible(true);
        setSize(350, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        btnDecipher.addActionListener(pressed -> {
            this.decipherMessage.setLength(0);
            int selected = a3RadioButton.isSelected() ? Integer.parseInt(a3RadioButton.getText())
                    : Integer.parseInt(a4RadioButton.getText());
            System.out.println("Selected Key: " + selected);
            this.originalMessage = tfMessage.getText();
            String message = tfMessage
                    .getText()
                    .replaceAll(" ", "")
                    .toLowerCase();
            System.out.println("Encipher Message: " + message);
            for (int i = 0; i < message.length(); i++) {  // checking every letter in input
                int positionOfCipherText = addSelectedKeyToPositionOfPlainText(message.charAt(i), selected);
                if (positionOfCipherText >= MAX_ALPHABET_INDEX) {
                    int rollBack = positionOfCipherText - MAX_ALPHABET_INDEX;
                    System.out.println("Cipher Text: " + message.charAt(i) + " -> " + ALPHABET.get(rollBack));
                    this.decipherMessage.append(ALPHABET.get(rollBack));
                } else {
                    System.out.println("Cipher Text: " + message.charAt(i) + " -> " + ALPHABET.get(positionOfCipherText));
                    this.decipherMessage.append(ALPHABET.get(positionOfCipherText));
                }
            }
            tfDecipheredMessage.setText(String.valueOf(this.decipherMessage).toUpperCase());
            System.out.println("Decipher Message: " + this.decipherMessage);
        });
    }


    private int addSelectedKeyToPositionOfPlainText(char everyLetterInMessage, int selectedKey) {
        for (int i = 0; i < everyLetterInMessage; i++) {
            for (int j = 0; j < ALPHABET.size(); j++) { // j is  yung index ng alphabet chechk nya kung may match tas mag run sya kada isang letter sa input
                if (everyLetterInMessage == ALPHABET.get(j)) {
                    return j + selectedKey;
                }
            }
        }
        return 0;
    }

    private void groupRadioButton() {
        ButtonGroup bgKeySelection = new ButtonGroup();
        bgKeySelection.add(a3RadioButton);
        bgKeySelection.add(a4RadioButton);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(5, 8, new Insets(12, 12, 12, 12), -1, -1));
        tfMessage = new JTextField();
        tfMessage.setEditable(true);
        tfMessage.setText("");
        mainPanel.add(tfMessage, new GridConstraints(1, 3, 1, 5, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a3RadioButton = new JRadioButton();
        a3RadioButton.setText("3");
        mainPanel.add(a3RadioButton, new GridConstraints(0, 3, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Key");
        mainPanel.add(label1, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Message");
        mainPanel.add(label2, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnDecipher = new JButton();
        btnDecipher.setText("Decipher");
        mainPanel.add(btnDecipher, new GridConstraints(2, 0, 1, 8, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setEnabled(true);
        label3.setText("Deciphered Message: ");
        mainPanel.add(label3, new GridConstraints(3, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tfDecipheredMessage = new JTextField();
        tfDecipheredMessage.setEditable(true);
        tfDecipheredMessage.setEnabled(true);
        mainPanel.add(tfDecipheredMessage, new GridConstraints(4, 0, 1, 8, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a4RadioButton = new JRadioButton();
        a4RadioButton.setText("4");
        mainPanel.add(a4RadioButton, new GridConstraints(0, 5, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
