package com.pa.note.v2ch11.LogEntry;

import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Method;
import com.sun.org.apache.bcel.internal.generic.*;

import java.io.File;
import java.io.IOException;

/**
 * Adds "entering" logs to all methods of a class that have the LogEntry annotation.
 *
 * @author Cay Horstmann
 * @version 1.10 2007-10-27
 */
public class EntryLogger {
    /**
     * Adds entry logging code to the given class
     *
     * @param args the name of the class file to patch
     */
    public static void main(String[] args) {
        try {
            if (args.length == 0) System.out.println("USAGE: java EntryLogger classname");
            else {
                JavaClass jc = Repository.lookupClass(args[0]);
                ClassGen cg = new ClassGen(jc);
                EntryLogger el = new EntryLogger(cg);
                el.convert();
                File f = new File(Repository.lookupClassFile(cg.getClassName()).getPath());
                cg.getJavaClass().dump(f.getPath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs an EntryLogger that inserts logging into annotated methods of a given class
     *
     * @param cg the class
     */
    public EntryLogger(ClassGen cg) {
        this.cg = cg;
        cpg = cg.getConstantPool();
    }

    /**
     * converts the class by inserting the logging calls.
     */
    public void convert() throws IOException {
//        for (Method m : cg.getMethods()) {
//            AnnotationEntry[] annotations = m.getAnnotationEntries();
//            for (AnnotationEntry a : annotations) {
//                if (a.getAnnotationType().equals("LLogEntry;")) {
//                    for (ElementValuePair p : a.getElementValuePairs()) {
//                        if (p.getNameString().equals("logger")) {
//                            String loggerName = p.getValue().stringifyValue();
//                            cg.replaceMethod(m, insertLogEntry(m, loggerName));
//                        }
//                    }
//                }
//            }
//        }
    }

    /**
     * Adds an "entering" call to the beginning of a method.
     *
     * @param m          the method
     * @param loggerName the name of the logger to call
     */
    private Method insertLogEntry(Method m, String loggerName) {
        MethodGen mg = new MethodGen(m, cg.getClassName(), cpg);
        String className = cg.getClassName();
        String methodName = mg.getMethod().getName();
        System.out.printf("Adding logging instructions to %s.%s%n", className, methodName);

        int getLoggerIndex = cpg.addMethodref("java.util.logging.Logger", "getLogger",
                "(Ljava/lang/String;)Ljava/util/logging/Logger;");
        int enteringIndex = cpg.addMethodref("java.util.logging.Logger", "entering",
                "(Ljava/lang/String;Ljava/lang/String;)V");

        InstructionList il = mg.getInstructionList();
        InstructionList patch = new InstructionList();
        patch.append(new PUSH(cpg, loggerName));
        patch.append(new INVOKESTATIC(getLoggerIndex));
        patch.append(new PUSH(cpg, className));
        patch.append(new PUSH(cpg, methodName));
        patch.append(new INVOKEVIRTUAL(enteringIndex));
        InstructionHandle[] ihs = il.getInstructionHandles();
        il.insert(ihs[0], patch);

        mg.setMaxStack();
        return mg.getMethod();
    }

    private ClassGen cg;
    private ConstantPoolGen cpg;
}