package swing.ch10;

import java.util.Arrays;
import java.util.Random;

public class LottoRandomNumber {
    private int lottoNumber[] = new int[6];

    public void makeNumber() {
        Random random = new Random(); // 난수 생성

        for (int i = 0; i < lottoNumber.length; i++) {
            int resultNumber = random.nextInt(45) + 1; // 난수 범위
            lottoNumber[i] = resultNumber; // 배열에 숫자 넣기

            for (int j = 0; j < i; j++) {
                if (lottoNumber[j] == lottoNumber[i]) {
                    i--;
                    break;
                }
            }
        }
        Arrays.sort(lottoNumber);

    }

    public int[] getNumber() {
        return lottoNumber;
    }

}