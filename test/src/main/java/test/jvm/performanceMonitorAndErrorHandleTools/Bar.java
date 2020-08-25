package test.jvm.performanceMonitorAndErrorHandleTools;

/**
 * 把编译好的 hsdis-amd64.dll放在 $JAVA_HOME/jre/bin/server 目录下。
 * 
 * java -XX:+UnlockDiagnosticVMOptions
 *      -XX:+PrintAssembly
 *      -Xcomp
 *      -XX:CompileCommand=dontinline,*Bar.sum
 *      -XX:CompileCommand=compileonly,*Bar.sum
 *
 *
 * @author hezhuofan
 */
public class Bar {
    int a=1;
    static int b=2;
    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args){
        new Bar().sum(3);
    }
}