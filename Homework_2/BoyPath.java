package Homework_2;

public class BoyPath implements CabbagePatch{

    @Override
    public void surprise() {
        System.out.println("   [BOY]");
        for (int i = 0; i < 5; i++) {
            int j = i;
            for (; j > 0; j--) {
                System.out.print(' ');
            }
            for (j = 5; j > i; j--) {
                System.out.print('V');
            }
            for (j = 5; j > i; j--) {
                System.out.print('V');
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
