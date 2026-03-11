package swing.ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JPanel panel;
    private JButton button;
    private JLabel textBox;
    private LottoPanel lottoPanel;

    public LottoFrame() {
        initData();
        setInitData();
        actionEvent();
    }

    private void initData() {
        panel = new JPanel();
        button = new JButton("Game start");
        textBox = new JLabel("Game start 버튼을 눌러주세요", JLabel.CENTER);
        lottoPanel = new LottoPanel();
    }

    private void setInitData() {
        setTitle("Lotto Game");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel.setLayout(null);
        add(panel);

        button.setBounds(0, 0, 800, 50);
        panel.add(button);

        textBox.setBounds(0, 80, 800, 100);
        textBox.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        textBox.setForeground(Color.GRAY);
        panel.add(textBox);

        lottoPanel.setBounds(50, 180, 700, 150);
        panel.add(lottoPanel);
        lottoPanel.setVisible(false);

        setVisible(true);
    }

    private void actionEvent() {
        button.addActionListener(this);
    }

    static class LottoPanel extends JPanel {
        private int[] numbers;

        public void setNumbers(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (numbers == null) {
                return;
            }

            for (int i = 0; i < numbers.length; i++) {
                int x = 20 + i * 110;
                int y = 30;

                int num = numbers[i];

                if(num <= 10){
                    g.setColor(Color.YELLOW);
                } else if(num <= 20){
                    g.setColor(Color.BLUE);
                } else if(num <= 30){
                    g.setColor(Color.RED);
                } else if(num <= 40){
                    g.setColor(Color.GRAY);
                } else {
                    g.setColor(Color.GREEN);
                }

                g.fillOval(x, y, 80, 80);

                g.setColor(Color.BLACK);
                g.drawOval(x, y, 80, 80);

                g.setColor(Color.WHITE);
                g.setFont(new Font("맑은 고딕", Font.BOLD, 24));
                g.drawString(String.valueOf(num), x + 28, y + 48);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            LottoRandomNumber lottoRandomNumber = new LottoRandomNumber();
            lottoRandomNumber.makeNumber();

            lottoPanel.setNumbers(lottoRandomNumber.getNumber());
            lottoPanel.setVisible(true);

            panel.remove(textBox);
            panel.revalidate();
            panel.repaint();

            lottoPanel.repaint();

        }
    }

    public static void main(String[] args) {
        new LottoFrame();
    }
}