package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChangeFrame extends JFrame implements ActionListener {

    private JButton button1;
    private JButton button2;
    private JPanel panel1;

    public ColorChangeFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        panel1 = new JPanel();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        panel1.setBackground(Color.YELLOW);
        add(panel1);
        panel1.add(button1);
        panel1.add(button2);
        setVisible(true);
    }

    private void addEventListener() {
        // JButton 클래스 내부에 만들어져 있는 메서드이다
        // this는 ActionListener 타입으로 바라볼 수 있음
        // --> // 1. 이벤트 리스너 등록
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    // 운영체제와 약속 되어 있는 추상 메서드를 오버라이드 했다
    // 이벤트가 발생 되면 이 메서드를 자동으로 수행해 (콜백) 라고 미리 정해져 있는 메서드이다
    // 인수값으로 정보 (객체)를 받을 수 있다.
    // 단, 어떤 컴포넌트에 이벤트를 등록할지 미리 정해줘야한다
    @Override
    public void actionPerformed(ActionEvent e) { // e 가 Object 타입으로 들어오게 되어 있다.
        // 2. actionPerformed 메서드가 콜백(호출되어) 되어 동적하게 끔 설계됨
        System.out.println("actionPerformed() 메서드가 호출 되었다.");
        if (e.getSource() == button1) {
            System.out.println("button1의 이벤트가 발생했습니다");
            panel1.setBackground(Color.BLUE);
        } else if (e.getSource() == button2) {
            System.out.println("button2의 이벤트가 발생했습니다");
            panel1.setBackground(Color.BLACK);
        }
//        JButton selectedButton = (JButton) e.getSource();
//        System.out.println(selectedButton.getText());
//        panel1.setBackground(Color.BLUE);
//
//        // ------------- 1번 누를 때 파랑 2번 누를 때 검점으로 동작 하게 코드 작성
//        if (selectedButton.getText().equals("button1")) {
//            System.out.println("버튼 : " + selectedButton.getText());
//            panel1.setBackground(Color.BLUE);
//        } else if (selectedButton.getText().equals("button2")) {
//            System.out.println("버튼 : " + selectedButton.getText());
//            panel1.setBackground(Color.BLACK);
//        }


    }
}
