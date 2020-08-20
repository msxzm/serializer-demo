package com.msxzm.core;

import com.msxzm.base.serializer.ISerializable;
import com.msxzm.base.serializer.Serializable;
import com.msxzm.base.serializer.SerializerField;
import com.msxzm.base.stream.InputStream;
import com.msxzm.base.stream.OutputStream;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Serializer序列化示例
 * @author zenghongming
 * @date 2020/8/20 11:06
 */
@Serializable
public class SerializerDemo implements ISerializable {
    @SerializerField
    private int a;
    @SerializerField
    private long b;
    @SerializerField
    private String c;
    @SerializerField
    private List<Integer> d;
    @SerializerField
    private Map<Integer, Integer> e;
    @SerializerField
    private List<List<Integer>> f;
    @SerializerField
    private Map<Integer, List<Integer>> g;
    @SerializerField
    private int[] h;
    @SerializerField
    private SerializableObject i;

    public void doWrite(OutputStream outputStream) throws IOException {

    }

    public void doRead(InputStream inputStream) throws IOException {

    }
}
