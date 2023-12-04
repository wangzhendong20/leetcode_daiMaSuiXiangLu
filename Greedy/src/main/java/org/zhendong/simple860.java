package org.zhendong;

public class simple860 {
    public boolean lemonadeChange(int[] bills) {
        int[] total = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                total[0]++;
            }else if (bills[i] == 10) {
                if (total[0] > 0) {
                    total[1]++;
                    total[0]--;
                }else {
                    return false;
                }
            }else {
                if (bills[i] == 20) {
                    if (total[1] > 0 && total[0] > 0) {
                        total[1]--;
                        total[0]--;
                    }else if (total[1] == 0 && total[0] >= 3) {
                        total[0] -= 3;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
