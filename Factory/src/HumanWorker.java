public class HumanWorker implements HomoSapiensWorker {

    @Override
    public void work() {
        System.out.println("HumanWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("HumanWorker.stopWorking");
    }

    @Override
    public void eat() {
        System.out.println("HumanWorker.eat");
    }
}