import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
  public void Doc(Scanner fileIn) {
    boolean done = false;
    while (!done) {
      try {
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
        ma = fileIn.nextInt();
        fileIn.nextLine();
        if (ma < 1000000 || ma > 9999999) throw new Exception("Invalid ma!!");
        done = true;
      } catch (InputMismatchException e) {
        System.out.println("Invalid ma!!");
      } catch (Exception e) {
        fileIn.nextLine();
        System.out.println(e.getMessage());
      }
    }
    done = false;
    while (!done) {
      try {
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
  public void Nhap(Scanner scanner) {
    boolean done = false;
    while (!done) {
      try {
        System.out.print("Nhap ten: ");
        ten = scanner.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid ten!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap tuoi: ");
        tuoi = scanner.nextInt();
        scanner.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid tuoi!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap ma: ");
        ma = scanner.nextInt();
        scanner.nextLine();
        if (ma < 1000000 || ma > 9999999) throw new Exception("Invalid ma!!");
        done = true;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid ma!!");
      } catch (Exception e) {
        scanner.nextLine();
        System.out.println(e.getMessage());
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap chuyen nganh: ");
        chuyenNganh = scanner.nextLine();
        done = true;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid chuyen nganh!!");
      }
    }
    done = false;
    while (!done) {
      try {
        System.out.print("Nhap nien khoa: ");
        nienKhoa = scanner.nextInt();
        scanner.nextLine();
        if (nienKhoa < 1900 || nienKhoa > 2030) throw new Exception("Invalid nien khoa!!");
        done = true;
      } catch (InputMismatchException e) {
        scanner.nextLine();
        System.out.println("Invalid nien khoa!!");
      } catch (Exception e){
        System.out.println(e.getMessage());
      }
    }  
  }
  
  @Override
  public void Ghi(DataOutputStream fileOut) {
    try {
      fileOut.write(ten.getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
      fileOut.write(String.valueOf(tuoi).getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
      fileOut.write(String.valueOf(ma).getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
      fileOut.write(chuyenNganh.getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
      fileOut.write(String.valueOf(nienKhoa).getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
    } catch (IOException e) {
      System.exit(0);
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