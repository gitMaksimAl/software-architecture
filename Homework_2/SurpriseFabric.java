package Homework_2;

public abstract class SurpriseFabric {
    abstract CabbagePatch getCabbage();

    void takeSurprise() {
        getCabbage().surprise();
    }
}
