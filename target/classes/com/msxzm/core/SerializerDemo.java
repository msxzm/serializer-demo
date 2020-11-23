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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Serializable
public class SerializerDemo implements ISerializable {
    private int a;
    private long b;
    private String c;
    private List<Integer> d;
    private Map<Integer, Integer> e;
    private List<List<Integer>> f;
    private Map<Integer, List<Integer>> g;
    private int[] h;
    private SerializableObject i;

    public SerializerDemo() {
    }

    public void doWrite(OutputStream outputStream) throws IOException {
        outputStream.writeInt(this.a);
        outputStream.writeLong(this.b);
        outputStream.writeBoolean(this.c != null);
        if (this.c != null) {
            outputStream.writeString(this.c);
        }

        outputStream.writeBoolean(this.d != null);
        Iterator var2;
        if (this.d != null) {
            outputStream.writeInt(this.d.size());
            var2 = this.d.iterator();

            while(var2.hasNext()) {
                Integer dElement = (Integer)var2.next();
                outputStream.writeBoolean(dElement != null);
                if (dElement != null) {
                    outputStream.writeInt(dElement);
                }
            }
        }

        outputStream.writeBoolean(this.e != null);
        Integer gKey;
        Integer fElementElement;
        Entry gElement;
        if (this.e != null) {
            outputStream.writeInt(this.e.size());
            var2 = this.e.entrySet().iterator();

            while(var2.hasNext()) {
                gElement = (Entry)var2.next();
                gKey = (Integer)gElement.getKey();
                outputStream.writeBoolean(gKey != null);
                if (gKey != null) {
                    outputStream.writeInt(gKey);
                }

                fElementElement = (Integer)gElement.getValue();
                outputStream.writeBoolean(fElementElement != null);
                if (fElementElement != null) {
                    outputStream.writeInt(fElementElement);
                }
            }
        }

        outputStream.writeBoolean(this.f != null);
        if (this.f != null) {
            outputStream.writeInt(this.f.size());
            var2 = this.f.iterator();

            label167:
            while(true) {
                List fElement;
                do {
                    if (!var2.hasNext()) {
                        break label167;
                    }

                    fElement = (List)var2.next();
                    outputStream.writeBoolean(fElement != null);
                } while(fElement == null);

                outputStream.writeInt(fElement.size());
                Iterator var11 = fElement.iterator();

                while(var11.hasNext()) {
                    fElementElement = (Integer)var11.next();
                    outputStream.writeBoolean(fElementElement != null);
                    if (fElementElement != null) {
                        outputStream.writeInt(fElementElement);
                    }
                }
            }
        }

        outputStream.writeBoolean(this.g != null);
        if (this.g != null) {
            outputStream.writeInt(this.g.size());
            var2 = this.g.entrySet().iterator();

            label149:
            while(true) {
                List gValue;
                do {
                    if (!var2.hasNext()) {
                        break label149;
                    }

                    gElement = (Entry)var2.next();
                    gKey = (Integer)gElement.getKey();
                    outputStream.writeBoolean(gKey != null);
                    if (gKey != null) {
                        outputStream.writeInt(gKey);
                    }

                    gValue = (List)gElement.getValue();
                    outputStream.writeBoolean(gValue != null);
                } while(gValue == null);

                outputStream.writeInt(gValue.size());
                Iterator var6 = gValue.iterator();

                while(var6.hasNext()) {
                    Integer gValueElement = (Integer)var6.next();
                    outputStream.writeBoolean(gValueElement != null);
                    if (gValueElement != null) {
                        outputStream.writeInt(gValueElement);
                    }
                }
            }
        }

        outputStream.writeBoolean(this.h != null);
        if (this.h != null) {
            outputStream.writeInt(this.h.length);

            for(int h_i = 0; h_i < this.h.length; ++h_i) {
                outputStream.writeInt(this.h[h_i]);
            }
        }

        outputStream.writeBoolean(this.i != null);
        if (this.i != null) {
            this.i.writeTo(outputStream);
        }

    }

    public void doRead(InputStream inputStream) throws IOException {
        this.a = inputStream.readInt();
        this.b = inputStream.readLong();
        if (inputStream.readBoolean()) {
            this.c = inputStream.readString();
        } else {
            this.c = null;
        }

        int hLen;
        int h_i;
        Integer gKey;
        if (inputStream.readBoolean()) {
            hLen = inputStream.readInt();
            this.d = new ArrayList(hLen);

            for(h_i = 0; h_i < hLen; ++h_i) {
                gKey = null;
                if (inputStream.readBoolean()) {
                    gKey = inputStream.readInt();
                } else {
                    gKey = null;
                }

                this.d.add(gKey);
            }
        }

        if (inputStream.readBoolean()) {
            hLen = inputStream.readInt();
            this.e = new HashMap(hLen);

            for(h_i = 0; h_i < hLen; ++h_i) {
                gKey = null;
                if (inputStream.readBoolean()) {
                    gKey = inputStream.readInt();
                } else {
                    gKey = null;
                }

                Integer eValue = null;
                if (inputStream.readBoolean()) {
                    eValue = inputStream.readInt();
                } else {
                    eValue = null;
                }

                this.e.put(gKey, eValue);
            }
        }

        int gValueLen;
        if (inputStream.readBoolean()) {
            hLen = inputStream.readInt();
            this.f = new ArrayList(hLen);

            for(h_i = 0; h_i < hLen; ++h_i) {
                List<Integer> fElement = null;
                if (inputStream.readBoolean()) {
                    int fElementLen = inputStream.readInt();
                    fElement = new ArrayList(fElementLen);

                    for(gValueLen = 0; gValueLen < fElementLen; ++gValueLen) {
                        Integer fElementElement = null;
                        if (inputStream.readBoolean()) {
                            fElementElement = inputStream.readInt();
                        } else {
                            fElementElement = null;
                        }

                        fElement.add(fElementElement);
                    }
                }

                this.f.add(fElement);
            }
        }

        if (inputStream.readBoolean()) {
            hLen = inputStream.readInt();
            this.g = new HashMap(hLen);

            for(h_i = 0; h_i < hLen; ++h_i) {
                gKey = null;
                if (inputStream.readBoolean()) {
                    gKey = inputStream.readInt();
                } else {
                    gKey = null;
                }

                List<Integer> gValue = null;
                if (inputStream.readBoolean()) {
                    gValueLen = inputStream.readInt();
                    gValue = new ArrayList(gValueLen);

                    for(int gValue_i = 0; gValue_i < gValueLen; ++gValue_i) {
                        Integer gValueElement = null;
                        if (inputStream.readBoolean()) {
                            gValueElement = inputStream.readInt();
                        } else {
                            gValueElement = null;
                        }

                        gValue.add(gValueElement);
                    }
                }

                this.g.put(gKey, gValue);
            }
        }

        if (inputStream.readBoolean()) {
            hLen = inputStream.readInt();
            this.h = new int[hLen];

            for(h_i = 0; h_i < hLen; ++h_i) {
                this.h[h_i] = inputStream.readInt();
            }
        }

        if (inputStream.readBoolean()) {
            this.i = new SerializableObject();
            this.i.readFrom(inputStream);
        } else {
            this.i = null;
        }

    }
}
