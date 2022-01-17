import java.util.Scanner;

public abstract class Nguoi {
  protected String ten;
  protected int tuoi;
  public Nguoi() {}
  public Nguoi(String ten, int tuoi) {
    this.ten = ten;
    this.tuoi = tuoi;
  }
  public abstract void Nhap(Scanner fileIn);
  public abstract void Xuat();
}
