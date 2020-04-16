package IFS;
//依赖库algs4请自行下载

        import edu.princeton.cs.algs4.StdArrayIO;
        import edu.princeton.cs.algs4.StdRandom;
        import edu.princeton.cs.algs4.StdDraw;

        import java.util.Arrays;

public class IFS {
//  public static void main(String[] args) {
//    // 迭代次数*（需输入在命令行中，或者直接赋值）*
//    int trials = Integer.parseInt(args[0]);
//
//    // 每个变换的执行概率
//    double[] dist = StdArrayIO.readDouble1D();
//
//    // 矩阵值
//    double[][] cx = StdArrayIO.readDouble2D();
//    double[][] cy = StdArrayIO.readDouble2D();
//
//    // 初始值 (x, y)
//    double x = 0.0, y = 0.0;
//
//    StdDraw.enableDoubleBuffering();
//    StdDraw.setCanvasSize(1000, 1000);
//    //       StdDraw.setXscale(-5, 5);
//    //       StdDraw.setYscale(0, 10);
////        StdDraw.setPenRadius(0.02);
//    StdDraw.setPenColor(StdDraw.RED);
//
//    for (int t = 0; t < trials; t++) {
//
//      // 根据概率分布随机选择变换
//      int r = StdRandom.discrete(dist);
//
//      // 迭代
//      double x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
//      double y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
//      x = x0;
//      y = y0;
//
//      // 绘制结果
//      StdDraw.point(x, y);
//
//      // 每迭代100次显示1次
//      if (t % 100 == 0) {
//        StdDraw.show();
//        StdDraw.pause(10);
//      }
//    }
//    StdDraw.show();
//  }

    private static IFSInfo barnsley;
    private static IFSInfo binary;
    private static IFSInfo culcita;
    private static IFSInfo cyclosorus;
    private static IFSInfo dragon;
    private static IFSInfo fern_sedgewick;
    private static IFSInfo fishbone;
    private static IFSInfo floor;
    private static IFSInfo koch;
    private static IFSInfo sierpinski;
    private static IFSInfo spiral;
    private static IFSInfo swirl;
    private static IFSInfo tree;
    private static IFSInfo zigzag;

    private static IFSInfo[] array;

    static {
        /**
         *  https://introcs.cs.princeton.edu/java/22library/barnsley.txt
         * Barnsley's original black spleenwort fern
         */
        IFSInfo barnsley = new IFSInfo();
        barnsley.name = "01-barnsley";
        barnsley.distInt = 4;
        barnsley.dist = "0.01  0.85  0.07  0.07";
        barnsley.rowColumnX = "4 3";
        barnsley.matrixX = new String[]{
                " 0.00  0.00  0.500",
                " 0.85  0.04  0.075",
                " 0.20 -0.26  0.400",
                "-0.15  0.28  0.575"
        };
        barnsley.rowColumnY = "4 3";
        barnsley.matrixY = new String[]{
                " 0.00  0.16  0.000",
                "-0.04  0.85  0.180",
                " 0.23  0.22  0.045",
                " 0.26  0.24 -0.086"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/binary.txt
         * pattern from Fractint
         */
        IFSInfo binary = new IFSInfo();
        binary.name = "02-binary";
        binary.distInt = 3;
        binary.dist = "0.3333  0.3333  0.3334";
        binary.rowColumnX = "3 3";
        binary.matrixX = new String[]{
                "0.5  0.0 -0.0063477",
                "0.5  0.0  0.4936544",
                "0.0 -0.5  0.9873085"
        };
        binary.rowColumnY = "3 3";
        binary.matrixY = new String[]{
                "0.0  0.5 -0.0000003",
                "0.0  0.5 -0.0000003",
                "0.5  0.0  0.5063492"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/culcita.txt
         */
        IFSInfo culcita = new IFSInfo();
        culcita.name = "03-culcita";
        culcita.distInt = 4;
        culcita.dist = "0.0200 0.8400 0.0700 0.0700";
        culcita.rowColumnX = "4 3";
        culcita.matrixX = new String[]{
                " 0.000  0.000  0.500",
                " 0.850  0.020  0.075",
                " 0.090 -0.280  0.455",
                "-0.090  0.280  0.545"
        };
        culcita.rowColumnY = "4 3";
        culcita.matrixY = new String[]{
                " 0.000  0.250 -0.014",
                "-0.020  0.830  0.110",
                " 0.300  0.110 -0.090",
                " 0.300  0.090 -0.080"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/cyclosorus.txt
         */
        IFSInfo cyclosorus = new IFSInfo();
        cyclosorus.name = "04-cyclosorus";
        cyclosorus.distInt = 4;
        cyclosorus.dist = "0.02 0.84 0.07 0.07";
        cyclosorus.rowColumnX = "4 3";
        cyclosorus.matrixX = new String[]{
                " 0.000  0.000  0.500",
                " 0.950  0.005  0.025",
                " 0.035 -0.200  0.474",
                "-0.040  0.200  0.528"
        };
        cyclosorus.rowColumnY = "4 3";
        cyclosorus.matrixY = new String[]{
                " 0.000  0.250 -0.040",
                "-0.005  0.930  0.053",
                " 0.160  0.040 -0.078",
                " 0.160  0.040 -0.068"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/dragon.txt
         * pattern from Fractint
         */
        IFSInfo dragon = new IFSInfo();
        dragon.name = "05-dragon";
        dragon.distInt = 2;
        dragon.dist = "0.787473  0.212527";
        dragon.rowColumnX = "2 3";
        dragon.matrixX = new String[]{
                "0.824074  0.281482 -0.1002660",
                "0.088272  0.520988  0.5344000"
        };
        dragon.rowColumnY = "2 3";
        dragon.matrixY = new String[]{
                "-0.212346  0.864198  0.0951123",
                "-0.463889 -0.377778  1.0415240"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/fern-sedgewick.txt
         */
        IFSInfo fern_sedgewick = new IFSInfo();
        fern_sedgewick.name = "06-fern_sedgewick";
        fern_sedgewick.distInt = 4;
        fern_sedgewick.dist = "0.02 0.15 0.13 0.70";
        fern_sedgewick.rowColumnX = "4 3";
        fern_sedgewick.matrixX = new String[]{
                " 0.000  0.000  0.500 ",
                "-0.139  0.263  0.570 ",
                " 0.170 -0.215  0.408 ",
                " 0.781  0.034  0.1075"
        };
        fern_sedgewick.rowColumnY = "4 3";
        fern_sedgewick.matrixY = new String[]{
                " 0.000  0.270  0.000 ",
                " 0.246  0.224 -0.036 ",
                " 0.222  0.176  0.0893",
                "-0.032  0.739  0.270 "
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/fishbone.txt
         */
        IFSInfo fishbone = new IFSInfo();
        fishbone.name = "07-fishbone";
        fishbone.distInt = 4;
        fishbone.dist = "0.0200 0.8400 0.0700 0.0700";
        fishbone.rowColumnX = "4 3";
        fishbone.matrixX = new String[]{
                " 0.000  0.000  0.500",
                " 0.950  0.002  0.025",
                " 0.035 -0.110  0.478",
                "-0.040  0.110  0.525"
        };
        fishbone.rowColumnY = "4 3";
        fishbone.matrixY = new String[]{
                " 0.000  0.250 -0.040",
                "-0.002  0.930  0.051",
                " 0.270  0.010 -0.135",
                " 0.270  0.010 -0.129"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/floor.txt
         */
        IFSInfo floor = new IFSInfo();
        floor.name = "08-floor";
        floor.distInt = 3;
        floor.dist = "0.3333  0.3333  0.3334";
        floor.rowColumnX = "3 3";
        floor.matrixX = new String[]{
                "0.0 -0.5  0.3267634",
                "0.5  0.0  0.2472109",
                "0.0  0.5  0.6620804"
        };
        floor.rowColumnY = "3 3";
        floor.matrixY = new String[]{
                " 0.5  0.0  0.0866182",
                " 0.0  0.5  0.5014877",
                "-0.5  0.0  0.5810401"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/koch.txt
         */
        IFSInfo koch = new IFSInfo();
        koch.name = "09-koch";
        koch.distInt = 5;
        koch.dist = "0.151515  0.253788  0.253788  0.151515  0.189394";
        koch.rowColumnX = "5 3";
        koch.matrixX = new String[]{
                "0.307692 -0.000000  0.7580704",
                "0.192308 -0.205882  0.3349620",
                "0.192308  0.205882  0.4707040",
                "0.307692 -0.000000 -0.0674990",
                "0.307692 -0.000000  0.3453822"
        };
        koch.rowColumnY = "5 3";
        koch.matrixY = new String[]{
                " 0.000000  0.294118  0.1604278",
                " 0.653846  0.088235  0.2709686",
                "-0.653846  0.088235  0.9231744",
                " 0.000000  0.294118  0.1604278",
                " 0.000000 -0.294118  0.2941176"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/sierpinski.txt
         */
        IFSInfo sierpinski = new IFSInfo();
        sierpinski.name = "10-sierpinski";
        sierpinski.distInt = 3;
        sierpinski.dist = "0.33 0.33 0.34";
        sierpinski.rowColumnX = "3 3";
        sierpinski.matrixX = new String[]{
                "0.50 0.00 0.00",
                "0.50 0.00 0.50",
                "0.50 0.00 0.25"
        };
        sierpinski.rowColumnY = "3 3";
        sierpinski.matrixY = new String[]{
                "0.00 0.50 0.000",
                "0.00 0.50 0.000",
                "0.00 0.50 0.433"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/spiral.txt
         */
        IFSInfo spiral = new IFSInfo();
        spiral.name = "11-spiral";
        spiral.distInt = 3;
        spiral.dist = "0.895652  0.052174  0.052174";
        spiral.rowColumnX = "3 3";
        spiral.matrixX = new String[]{
                " 0.787879 -0.424242  0.2819252",
                "-0.121212  0.257576 -0.1115594",
                " 0.181818 -0.136364  1.0177017"
        };
        spiral.rowColumnY = "3 3";
        spiral.matrixY = new String[]{
                "0.242424  0.859848  0.0195945",
                "0.151515  0.053030  0.0619661",
                "0.090909  0.181818  0.1113490"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/swirl.txt
         */
        IFSInfo swirl = new IFSInfo();
        swirl.name = "12-swirl";
        swirl.distInt = 2;
        swirl.dist = "0.9126750  0.0873250";
        swirl.rowColumnX = "2 3";
        swirl.matrixX = new String[]{
                " 0.745455 -0.459091  0.2733004",
                "-0.424242 -0.065152  1.0930777"
        };
        swirl.rowColumnY = "2 3";
        swirl.matrixY = new String[]{
                " 0.406061  0.887121 -0.1339233",
                "-0.175758 -0.218182  0.7620266"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/tree.txt
         */
        IFSInfo tree = new IFSInfo();
        tree.name = "13-tree";
        tree.distInt = 6;
        tree.dist = "0.1  0.1  0.2  0.2  0.2  0.2";
        tree.rowColumnX = "6 3";
        tree.matrixX = new String[]{
                " 0.00  0.00  0.550",
                "-0.05  0.00  0.525",
                " 0.46 -0.15  0.270",
                " 0.47 -0.15  0.265",
                " 0.43  0.28  0.285",
                " 0.42  0.26  0.290"
        };
        tree.rowColumnY = "6 3";
        tree.matrixY = new String[]{
                " 0.00  0.60  0.000",
                "-0.50  0.00  0.750",
                " 0.39  0.38  0.105",
                " 0.17  0.42  0.465",
                "-0.25  0.45  0.625",
                "-0.35  0.31  0.525"
        };

        /**
         *  https://introcs.cs.princeton.edu/java/22library/zigzag.txt
         */
        IFSInfo zigzag = new IFSInfo();
        zigzag.name = "14-zigzag";
        zigzag.distInt = 2;
        zigzag.dist = "0.888128  0.111872";
        zigzag.rowColumnX = "2 3";
        zigzag.matrixX = new String[]{
                "-0.632407 -0.614815  1.2002857",
                "-0.036111  0.444444  0.7251636"
        };
        zigzag.rowColumnY = "2 3";
        zigzag.matrixY = new String[]{
                "-0.545370  0.659259  0.4009171",
                " 0.210185  0.037037  0.7279627"
        };
        IFS.barnsley = barnsley;
        IFS.binary = binary;
        IFS.culcita = culcita;
        IFS.cyclosorus = cyclosorus;
        IFS.dragon = dragon;
        IFS.fern_sedgewick = fern_sedgewick;
        IFS.fishbone = fishbone;
        IFS.floor = floor;
        IFS.koch = koch;
        IFS.sierpinski = sierpinski;
        IFS.spiral = spiral;
        IFS.swirl = swirl;
        IFS.tree = tree;
        IFS.zigzag = zigzag;

        array = new IFSInfo[]{
                barnsley,
                binary,
                culcita,
                cyclosorus,
                dragon,
                fern_sedgewick,
                fishbone,
                floor,
                koch,
                sierpinski,
                spiral,
                swirl,
                tree,
                zigzag
        };

    }

    public static void main(String[] args) {
//        execute(barnsley);
        for (IFS.IFSInfo ifsInfo : array) {
            execute(ifsInfo);
        }
    }

    private static void execute(IFSInfo ifsInfo) {
        // 迭代次数
        int trials = 400000;//900000

//        double[] dist0 = StdArrayIO.readDouble1D();
        // 每个变换的执行概率
        double[] dist = parse(ifsInfo.distInt, ifsInfo.dist);

        // 矩阵值
        double[][] cx = parse(ifsInfo.rowColumnX, ifsInfo.matrixX);
        double[][] cy = parse(ifsInfo.rowColumnY, ifsInfo.matrixY);

        // 初始值 (x, y)
        double x = 0.0, y = 0.0;

        StdDraw.enableDoubleBuffering();
//        StdDraw.setCanvasSize(1000, 1000);
        StdDraw.setCanvasSize(650, 650);
        //       StdDraw.setXscale(-5, 5);
        //       StdDraw.setYscale(0, 10);
//        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.RED);

        for (int t = 0; t < trials; t++) {

            // 根据概率分布随机选择变换
            int r = StdRandom.discrete(dist);

            // 迭代
            double x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
            double y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
            x = x0;
            y = y0;

            // 绘制结果
            StdDraw.point(x, y);

            // 每迭代100次显示1次
            if (t % 100 == 0) {
//                System.out.println("t:" + t);
                StdDraw.show();
                StdDraw.pause(10);
            }
        }
//        StdDraw.show();
        String path = "d://"+ifsInfo.name+".png";
        System.out.println(path);
        StdDraw.save(path);
        StdDraw.clear();
        System.out.println("end2");
    }


    private static double[][] parse(String rowColumn, String[] matrix) {
        String[] rowColumnArr = rowColumn.trim().split("\\s+");
        int row = Integer.valueOf(rowColumnArr[0]);
        int column = Integer.valueOf(rowColumnArr[1]);
        if (matrix.length != row) {
            throw new RuntimeException("the row is error");
        }
        double[][] result = new double[row][column];
        for (int i = 0; i < matrix.length; i++) {
            String[] split = matrix[i].trim().split("\\s+");
            if (split.length != column) {
                throw new RuntimeException("the column is error");
            }
            for (int j = 0; j < split.length; j++) {
                result[i][j] = Double.valueOf(split[j].trim());
            }
        }
        return result;
    }

    private static double[] parse(int distInt, String dist) {
        String[] split = dist.trim().split("\\s+");
        if (distInt != split.length) {
            throw new RuntimeException("the dist is error");
        }
        double[] result = new double[distInt];
        for (int i = 0; i < split.length; i++) {
            result[i] = Double.valueOf(split[i]);
        }
        return result;
    }

    static class IFSInfo {
        public String name;
        public int distInt;
        public String dist;
        public String rowColumnX;
        public String[] matrixX;
        public String rowColumnY;
        public String[] matrixY;

        public IFSInfo() {
        }
    }

}
