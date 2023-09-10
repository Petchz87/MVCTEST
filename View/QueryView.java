package View;

import javax.swing.*;

import Controller.QueryController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryView {
    private JFrame frame;
    private JComboBox<String> languageComboBox;
    private JTextArea scriptTextArea;
    private JComboBox<String> outputComboBox;
    private JTextArea resultTextArea;
    public void createGUI(QueryController controller) {
        frame = new JFrame("Query Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JPanel showOutput = new JPanel(new BorderLayout());

        JLabel languageLabel = new JLabel("Query Language:");
        String[] languages = { "SQL", "MQL" };
        languageComboBox = new JComboBox<>(languages);

        JLabel outputLabel = new JLabel("Layout Output:");
        String[] outputs = { "1", "2" };
        outputComboBox = new JComboBox<>(outputs);

        JLabel scriptLabel = new JLabel("Query Script:");
        scriptTextArea = new JTextArea();
        scriptTextArea.setLineWrap(true); // Enable word wrap
        scriptTextArea.setWrapStyleWord(true);

        JButton executeButton = new JButton("Execute");

        inputPanel.add(languageLabel);
        inputPanel.add(languageComboBox);
        inputPanel.add(outputLabel);
        inputPanel.add(outputComboBox);
        inputPanel.add(scriptLabel);

        // Wrap the scriptTextArea in a JScrollPane to enable scrolling
        JScrollPane scriptScrollPane = new JScrollPane(scriptTextArea);
        inputPanel.add(scriptScrollPane);

        inputPanel.add(new JLabel());
        inputPanel.add(executeButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        resultTextArea.setLineWrap(true);
        resultTextArea.setWrapStyleWord(true);

        showOutput.add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(showOutput, BorderLayout.CENTER);

        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String queryLanguage = languageComboBox.getSelectedItem().toString();
                String queryScript = scriptTextArea.getText();
                String queryOutput = outputComboBox.getSelectedItem().toString();

                controller.executeQuery(queryLanguage, queryScript, queryOutput);
            }
        });
        frame.setVisible(true);
    }

    public void setResultText(String resultText) {
        resultTextArea.setText(resultText);
    }
}
