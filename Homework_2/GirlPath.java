package Homework_2;

public class GirlPath implements CabbagePatch {

    @Override
    public void surprise() {
        System.out.println("   [GIRL]");
        for (int i = 0; i < 5; i++) {
            int j = 5;
            for (; j > i; j--) {
                System.out.print(' ');
            }
            for (j = i; j >= 0; j--) {
                System.out.print('A');
            }
            for (j = i; j >= 0; j--) {
                System.out.print('A');
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
