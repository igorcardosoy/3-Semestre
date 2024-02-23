package view;

public enum MenuOption {

  REGISTER(0),
  UPDATE(1),
  LIST_ALL(2),
  REMOVE(3),
  QUIT(4);

  private final int value;

  MenuOption(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

}