package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener {
    // 이전에 했던 코드 한 번 더 복습
    private JButton button1;
    private JButton button2;

    private JPanel panel1;
    private JPanel panel2;

    public ColorFrame() {
        initData();
        setInitLayout();
        addEventListener();

    }

    public void initData() {
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        panel1.setBackground(Color.YELLOW);

        panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);

        button1 = new JButton("button1");
        button2 = new JButton("button2");
    }

    public void setInitLayout() {
        setLayout(new GridLayout(2, 1)); // 전체를 어떻게 나눌지 (행, 열)

        add(panel1);
        add(panel2);
        // 패널 내부의 버튼 위치 설정 (위치, 세로 공백 크기, 가로 공백 크기)
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        panel1.add(button1);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        panel2.add(button2);

        setVisible(true);
    }

    private void addEventListener() { // 액션 리스너 추가 --> 동작할 객체의 액션 리스너를 부여
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // 액션 리스너의 행동 추가

        if(e.getSource() == button1) {
            // e.getScore --> 이벤트가 발생한 객체의 주소 값을 불러와 button1이 맞는지 확인
            panel1.setBackground(Color.GREEN);

        } else if(e.getSource() == button2) {
            panel2.setBackground(Color.PINK);

        }
    }
}
