package lab3.problem_6;

public interface Trainable {
    boolean train(String command);
    String[] getLearnedCommands();
}