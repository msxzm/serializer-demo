//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.msxzm.core;

import com.msxzm.base.serializer.ISerializable;
import com.msxzm.base.serializer.Serializable;
import com.msxzm.base.stream.InputStream;
import com.msxzm.base.stream.OutputStream;
import java.io.IOException;

@Serializable
public class SerializableObject implements ISerializable {
    private int a;

    public SerializableObject() {
    }

    public void doWrite(OutputStream outputStream) throws IOException {
        outputStream.writeInt(this.a);
    }

    public void doRead(InputStream inputStream) throws IOException {
        this.a = inputStream.readInt();
    }
}
