package Lesson_1.InMemoryModel;

import java.util.ArrayList;
import java.util.List;

import Lesson_1.ModelElements.Camera;
import Lesson_1.ModelElements.Flash;
import Lesson_1.ModelElements.PoligonalModel;
import Lesson_1.ModelElements.Scene;

public class ModelStore implements IModelChanger, IModelChangedObserver{
    List<PoligonalModel> Models = null;
    List<Scene> Scenes = null;
    List<Flash> Flashes = null;
    List<Camera> Cameras = null;
    private List<IModelChangedObserver> changeObservers = null;

    public ModelStore(List<IModelChangedObserver> observers) {
        this.Cameras = new ArrayList<>();
        this.Flashes = new ArrayList<>();
        this.Models = new ArrayList<>();
        this.changeObservers = observers;
    }

    public Scene GetScena(int n) {
        return this.Scenes.get(n);
    }

    @Override
    public void NotifyChange(IModelChanger changer) {

    }

    public void ApplyUpdateModel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ApplyUpdateModel'");
    }
}
