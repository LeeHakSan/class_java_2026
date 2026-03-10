package swing.ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 키 리스너를 수현 하여 키보드 입력을 받아 라벨을 움직이는 클래스
 */
public class MoveCharFrame2 extends JFrame {

    private JLabel label;
    private final int MOVE_STEP = 10;
    private final int INIT_X = 225;
    private final int INIT_Y = 200;
    private final int FRAME_SIZE = 500;

    private int count = 0;


    public MoveCharFrame2() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("방향키로 별 움직이기 실습 ");
        setSize(FRAME_SIZE, FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        label = new JLabel("★"); // 라벨 추가
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // 폰트 설정
        label.setSize(50, 50); // 라벨 자체의 크기
        label.setLocation(INIT_X, INIT_Y); // 초기 시작 위치 중앙 부근
    }

    private void setInitLayout() {
        // 중요
        setLayout(null); // 좌표로 직접 움직이기 위해 기본 레이아웃 제거
        add(label);
        setVisible(true);
    }

    private void addEventListener() {
        // 1. 프레임에 키 리스너를 등록 (나 자신을 리스너로 임명 가능)
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = label.getX(); // 현재 자신의 x 좌표값을 반환
                int y = label.getY(); // 현재 자신의 y 좌표값을 반환
                // 방향키에 따라 새로운 좌표 설정

                setTitle("방향키로 별 움직이기 실습, 별을 움직인 횟수 | " + count);
                if (keyCode == KeyEvent.VK_LEFT) {
                    label.setLocation(x - MOVE_STEP, y);
                    ++count;

                } else if (keyCode == KeyEvent.VK_UP) {
                    label.setLocation(x, y - MOVE_STEP);
                    ++count;
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    label.setLocation(x + MOVE_STEP, y);
                    ++count;

                } else if (keyCode == KeyEvent.VK_DOWN) {
                    label.setLocation(x, y + MOVE_STEP);
                    ++count;
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    count = 0;
                    label.setLocation(INIT_X, INIT_Y);
                }

                label.setText("★");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                label.setText("☆");
            }
        });

        // 필수
        // 키보드 이벤트를 받기 위해 프레임이 포커스를 가질 수 있게 함.
        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    public static void main(String[] args) {
        new MoveCharFrame2();
    }
}
