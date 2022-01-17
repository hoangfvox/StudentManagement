import java.util.InputMismatchException;
import java.util.Scanner;

public class SinhVien extends Nguoi {
  private int ma;
  private String chuyenNganh;
  private int nienKhoa;
  public SinhVien() {}
  public SinhVien(String ten, int tuoi, int ma, String chuyenNganh, int nienKhoa) {
    super(ten, tuoi);
    this.ma = ma;
    this.chuyenNganh = chuyenNganh;
    this.nienKhoa = nienKhoa;
  }
  public int getMa() {
    return ma;
  }
  public String getChuyenNganh() {
    return chuyenNganh;
  }
  @Override
  public void Nhap(Scanner fileIn) {
    boolean done = false;
    while (!done) {
      try {
        System.out.print("Nhap ten: ");
        ten = fileIn.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        fileIn.nextLine();
        System.out.println("Invalid ten!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap tuoi: ");
        tuoi = fileIn.nextInt();
        fileIn.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        fileIn.nextLine();
        System.out.println("Invalid tuoi!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap ma: ");
        ma = fileIn.nextInt();
        fileIn.nextLine();
        if (ma < 1000000 || ma > 9999999) throw new Exception("Invalid ma!!");
        done = true;
      } catch (InputMismatchException e) {
        fileIn.nextLine();
        System.out.println("Invalid ma!!");
      } catch (Exception e) {
        fileIn.nextLine();
        System.out.println(e.getMessage());
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap chuyen nganh: ");
        chuyenNganh = fileIn.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        fileIn.nextLine();
        System.out.println("Invalid chuyen nganh!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap nien khoa: ");
        nienKhoa = fileIn.nextInt();
        fileIn.nextLine();
        if (nienKhoa < 1900 || nienKhoa > 2030) throw new Exception("Invalid nien khoa!!");
        done = true;
      } catch (InputMismatchException e) {
        fileIn.nextLine();
        System.out.println("Invalid nien khoa!!");
      } catch (Exception e){
        System.out.println(e.getMessage());
      }
    }  
  }
  @Override
  public void Xuat() {
    System.out.println("Ten: " + ten);
    System.out.println("Tuoi: " + tuoi);
    System.out.println("Ma SV: " + ma);
    System.out.println("Chuyen nganh: " + chuyenNganh);
    System.out.println("Nien khoa: " + nienKhoa);
  }
}