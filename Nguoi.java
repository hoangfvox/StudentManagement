import java.io.DataOutputStream;
import java.util.Scanner;

public abstract class Nguoi {
  protected String ten;
  protected int tuoi;
  public Nguoi() {}
  public Nguoi(String ten, int tuoi) {
    this.ten = ten;
    this.tuoi = tuoi;
  }
  public abstract void Nhap(Scanner scanner);
  public abstract void Doc(Scanner fileIn);
  public abstract void Ghi(DataOutputStream fileOut);
  public abstract void Xuat();
}
