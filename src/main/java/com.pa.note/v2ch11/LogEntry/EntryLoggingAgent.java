package com.pa.note.v2ch11.LogEntry;

import com.sun.org.apache.bcel.internal.classfile.ClassParser;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.generic.ClassGen;

import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author Cay Horstmann
 * @version 1.00 2004-08-17
 */
public class EntryLoggingAgent {
    public static void premain(final String arg, Instrumentation instr) {
        instr.addTransformer(new ClassFileTransformer() {
            public byte[] transform(ClassLoader loader, String className, Class<?> cl,
                                    ProtectionDomain pd, byte[] data) {
                if (!className.equals(arg)) return null;
                try {
                    ClassParser parser = new ClassParser(new ByteArrayInputStream(data), className
                            + ".java");
                    JavaClass jc = parser.parse();
                    ClassGen cg = new ClassGen(jc);
                    EntryLogger el = new EntryLogger(cg);
                    el.convert();
                    return cg.getJavaClass().getBytes();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }
}
