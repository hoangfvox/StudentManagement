import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Truong implements ITruong {
  public static void clrscr(){
    //Clears Screen in java
    try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
  }
  public ArrayList<SinhVien> sinhvien = new ArrayList<SinhVien>();


  @Override
  public void DocFileSV() {
    Scanner fileIn = null;
    try {
      fileIn = new Scanner(new FileInputStream("sinhvien.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      System.exit(0);
    }
    int n = Integer.parseInt(fileIn.nextLine());
    for (int i = 0; i < n; i++) {
      SinhVien sv = new SinhVien();
      sv.Doc(fileIn);
      sinhvien.add(sv);
    }
    fileIn.close();
  }
  @Override
  public void GhiFileSV() {
    DataOutputStream fileOut = null;
    try {
      fileOut = new DataOutputStream(new FileOutputStream("sinhvien.txt"));
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
      System.exit(0);
    }
    try {
      fileOut.write(String.valueOf(sinhvien.size()).getBytes());
      fileOut.write(System.getProperty("line.separator").getBytes());
      for (SinhVien sv : sinhvien) {
        sv.Ghi(fileOut);
      }
      fileOut.close();
    } catch (IOException e) {
      System.exit(0);
    }
  }
  @Override
  public void NhapThemSV() {
    Scanner in = new Scanner(System.in);
    int n = 1;
    for (int i = 0; i < n; i++) {
      SinhVien sv = new SinhVien();
      sv.Nhap(in);
      sinhvien.add(sv);
    }
  }

  @Override
  public void XuatSV() {
    for (SinhVien sv : sinhvien) {
      sv.Xuat();
      System.out.println("-------------");
    }
    System.out.println();
  }

  @Override
  public void SuaSV() {
    Scanner in = new Scanner(System.in);
    System.out.print("Nhap ID cua sinh vien can sua thong tin: ");
    int maSua = Integer.parseInt(in.nextLine());
    for (SinhVien sv : sinhvien)
      if (sv.getMa() == maSua) {
        sv.Nhap(in);
      }
  }

  @Override
  public void XoaSV() {
    Scanner in = new Scanner(System.in);
    int maXoa = 0;
    boolean done = false;
    while (!done) {
      try {
        System.out.print("Nhap ID cua sinh vien can xoa: ");
        maXoa = in.nextInt();
        done = true;
      } catch (InputMismatchException e) {
        in.nextLine();
        System.out.println("Nhap sai!!");
      }
    }
    boolean has = false;
    for (int i = 0; i < sinhvien.size(); i++) {
      SinhVien sv = sinhvien.get(i);
      if (sv.getMa() == maXoa) {
        sinhvien.remove(sv);
        has = true;
      }
    }
    if (has == true) System.out.println("Da xoa!!!");
    else System.out.println("Khong co sinh vien mang ma nay!!");
  }

  @Override
  public void SapXepSV() {
    Scanner in = new Scanner(System.in);
    System.out.println("1. Sap xep theo MSSV");
		System.out.println("2. Sap xep theo thu tu chuyen nganh");
		System.out.println("Nhap lua chon: ");
		int chon = in.nextInt();
		switch (chon) {
			case 1 : {
				sinhvien.sort(Comparator.comparingInt(SinhVien::getMa));
				break;
			}
			case 2: {
				sinhvien.sort(Comparator.comparing(SinhVien::getChuyenNganh));
				break;
			}
		}
  }
  public void inMenu() {
    Scanner in = new Scanner(System.in);
    int luachon;
    while (true) {
      clrscr();
      sinhvien = new ArrayList<SinhVien>();
      DocFileSV();
      System.out.println("-----LUA CHON-----");
      System.out.println("1. Them sinh vien");
      System.out.println("2. Xuat thong tin sinh vien");
      System.out.println("3. Chinh sua thong tin sinh vien");
      System.out.println("4. Sap xep sinh vien");
      System.out.println("5. Xoa sinh vien");
      try {
        System.out.print("Nhap lua chon: "); 
        luachon = in.nextInt();
        switch (luachon) {
          case 1:
            NhapThemSV();
            break;
          case 2:
            XuatSV();
            // Pause Screen in Java
            new java.util.Scanner(System.in).nextLine();
            break;
          case 3:
            SuaSV();
            break;
          case 4:
            SapXepSV();
            break;
          case 5:
            XoaSV();
            // Pause Screen in Java
            new java.util.Scanner(System.in).nextLine();
            break;
        }
        GhiFileSV();
        if (luachon == 0) break;
      } catch (InputMismatchException e) {
        in.nextLine();
      }
    }
  }
  public static void main(String[] args) {
    Truong truong = new Truong();
    truong.inMenu();
  }
}