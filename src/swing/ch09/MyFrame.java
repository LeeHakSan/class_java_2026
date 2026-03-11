package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyFrame extends JFrame {
    private JLabel backgroundMap;
    private JLabel player;

    private static final String IMG_PATH_BG = "images/backgroundMap.png";
    private static final String IMG_PATH_PLAYER_L = "images/playerL.png";
    private static final String IMG_PATH_PLAYER_R = "images/playerR.png";
    private static final int FRAME_WIDTH = 1000;
    private static final int FRAME_HEIGHT = 600;
    public final int PLAYER_LOCATION_X = 200;
    public final int PLAYER_LOCATION_Y = 150;
    public final int MOVE_STEP = 10;
    // 아이콘 객체를 생성 해서 플레이어가 동작할 때 객체를 새로 생성 하지 않고 아이콘 이미지만 바꿔서 메모리를 절약
    private ImageIcon playerL;
    private ImageIcon playerR;

    public MyFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }


    private void initData() {
        setTitle("이미지 사용 연습");
        setSize(FRAME_WIDTH, (FRAME_HEIGHT + 39));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon(IMG_PATH_BG);
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        backgroundMap.setLocation(0, 0);

        // 플레이어 설정
        ImageIcon playerIconL = new ImageIcon(IMG_PATH_PLAYER_L);
        ImageIcon playerIconR = new ImageIcon(IMG_PATH_PLAYER_R);

        player = new JLabel(playerIconL);
        player.setSize(100, 100);
        player.setLocation(PLAYER_LOCATION_X, PLAYER_LOCATION_Y);

    }

    private void setInitLayout() {
        setLayout(null); // 좌표기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = player.getX();
                int y = player.getY();
                characterMovement(keyCode);
            }
        });
    }

    public void characterMovement(int keyCode) {
        int x = player.getX();
        int y = player.getY();

        if (keyCode == KeyEvent.VK_LEFT) {
            player.setIcon(playerL);
            player.setLocation((x - MOVE_STEP), y);

        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.setIcon(playerR);
            player.setLocation((x + MOVE_STEP), y);

        } else if (keyCode == KeyEvent.VK_UP) {
            player.setLocation(x, (y - MOVE_STEP));

        } else if (keyCode == KeyEvent.VK_DOWN) {
            player.setLocation(x, (y + MOVE_STEP));

        }
    }

//    public void block() {
//
//    }

    // 테스트 코드 (메인 쓰레드)
    public static void main(String[] args) {
        new MyFrame();
    }
}
