package Lesson_3;

public class LSP {

    public abstract class QuadRangle {
        public abstract int getArea();
    }

    public class Rectangle extends QuadRangle {

        private int Width;
        private int Height;

        public Rectangle(int width, int height) {
            this.Height = height;
            this.Width = width;
        }

        public int getHeight() {
            return Height;
        }

        public int getWidth() {
            return Width;
        }

        public int getArea() {
            return this.Height * this.Width;
        }
    
        public void setHeight(int height) {
            Height = height;
        }

        public void setWidth(int width) {
            Width = width;
        }
    }

    public class Square extends QuadRangle{

        private int Width;

        public Square(int width) {
            this.Width = width;
        }

        @Override
        public int getArea() {
            return (int)Math.pow(Width, 2);
        }

        public int getWidth() {
            return Width;
        }

        public void setWidth(int width) {
            Width = width;
        }
    }
}
