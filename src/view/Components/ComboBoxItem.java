package view.Components;

public class ComboBoxItem {
  private String displayValue;
  private String value;

  public ComboBoxItem(String displayValue, String value) {
      this.displayValue = displayValue;
      this.value = value;
  }

  @Override
  public String toString() {
      return displayValue;
  }

  public String getValue() {
      return value;
  }
}
