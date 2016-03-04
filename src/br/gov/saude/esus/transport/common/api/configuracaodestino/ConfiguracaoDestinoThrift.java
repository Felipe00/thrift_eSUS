/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package br.gov.saude.esus.transport.common.api.configuracaodestino;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfiguracaoDestinoThrift implements org.apache.thrift.TBase<ConfiguracaoDestinoThrift, ConfiguracaoDestinoThrift._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ConfiguracaoDestinoThrift");

  private static final org.apache.thrift.protocol.TField INSTALACAO_FIELD_DESC = new org.apache.thrift.protocol.TField("instalacao", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USO_FIELD_DESC = new org.apache.thrift.protocol.TField("uso", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField VERSAO_FIELD_DESC = new org.apache.thrift.protocol.TField("versao", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ConfiguracaoDestinoThriftStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ConfiguracaoDestinoThriftTupleSchemeFactory());
  }

  private TipoInstalacaoDestinoThrift instalacao; // required
  private TipoUsoDestinoThrift uso; // required
  private VersaoThrift versao; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see TipoInstalacaoDestinoThrift
     */
    INSTALACAO((short)1, "instalacao"),
    /**
     * 
     * @see TipoUsoDestinoThrift
     */
    USO((short)2, "uso"),
    VERSAO((short)3, "versao");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // INSTALACAO
          return INSTALACAO;
        case 2: // USO
          return USO;
        case 3: // VERSAO
          return VERSAO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.INSTALACAO, new org.apache.thrift.meta_data.FieldMetaData("instalacao", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TipoInstalacaoDestinoThrift.class)));
    tmpMap.put(_Fields.USO, new org.apache.thrift.meta_data.FieldMetaData("uso", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TipoUsoDestinoThrift.class)));
    tmpMap.put(_Fields.VERSAO, new org.apache.thrift.meta_data.FieldMetaData("versao", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, VersaoThrift.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ConfiguracaoDestinoThrift.class, metaDataMap);
  }

  public ConfiguracaoDestinoThrift() {
  }

  public ConfiguracaoDestinoThrift(
    TipoInstalacaoDestinoThrift instalacao,
    TipoUsoDestinoThrift uso,
    VersaoThrift versao)
  {
    this();
    this.instalacao = instalacao;
    this.uso = uso;
    this.versao = versao;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ConfiguracaoDestinoThrift(ConfiguracaoDestinoThrift other) {
    if (other.isSetInstalacao()) {
      this.instalacao = other.instalacao;
    }
    if (other.isSetUso()) {
      this.uso = other.uso;
    }
    if (other.isSetVersao()) {
      this.versao = new VersaoThrift(other.versao);
    }
  }

  public ConfiguracaoDestinoThrift deepCopy() {
    return new ConfiguracaoDestinoThrift(this);
  }

  @Override
  public void clear() {
    this.instalacao = null;
    this.uso = null;
    this.versao = null;
  }

  /**
   * 
   * @see TipoInstalacaoDestinoThrift
   */
  public TipoInstalacaoDestinoThrift getInstalacao() {
    return this.instalacao;
  }

  /**
   * 
   * @see TipoInstalacaoDestinoThrift
   */
  public void setInstalacao(TipoInstalacaoDestinoThrift instalacao) {
    this.instalacao = instalacao;
  }

  public void unsetInstalacao() {
    this.instalacao = null;
  }

  /** Returns true if field instalacao is set (has been assigned a value) and false otherwise */
  public boolean isSetInstalacao() {
    return this.instalacao != null;
  }

  public void setInstalacaoIsSet(boolean value) {
    if (!value) {
      this.instalacao = null;
    }
  }

  /**
   * 
   * @see TipoUsoDestinoThrift
   */
  public TipoUsoDestinoThrift getUso() {
    return this.uso;
  }

  /**
   * 
   * @see TipoUsoDestinoThrift
   */
  public void setUso(TipoUsoDestinoThrift uso) {
    this.uso = uso;
  }

  public void unsetUso() {
    this.uso = null;
  }

  /** Returns true if field uso is set (has been assigned a value) and false otherwise */
  public boolean isSetUso() {
    return this.uso != null;
  }

  public void setUsoIsSet(boolean value) {
    if (!value) {
      this.uso = null;
    }
  }

  public VersaoThrift getVersao() {
    return this.versao;
  }

  public void setVersao(VersaoThrift versao) {
    this.versao = versao;
  }

  public void unsetVersao() {
    this.versao = null;
  }

  /** Returns true if field versao is set (has been assigned a value) and false otherwise */
  public boolean isSetVersao() {
    return this.versao != null;
  }

  public void setVersaoIsSet(boolean value) {
    if (!value) {
      this.versao = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case INSTALACAO:
      if (value == null) {
        unsetInstalacao();
      } else {
        setInstalacao((TipoInstalacaoDestinoThrift)value);
      }
      break;

    case USO:
      if (value == null) {
        unsetUso();
      } else {
        setUso((TipoUsoDestinoThrift)value);
      }
      break;

    case VERSAO:
      if (value == null) {
        unsetVersao();
      } else {
        setVersao((VersaoThrift)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case INSTALACAO:
      return getInstalacao();

    case USO:
      return getUso();

    case VERSAO:
      return getVersao();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case INSTALACAO:
      return isSetInstalacao();
    case USO:
      return isSetUso();
    case VERSAO:
      return isSetVersao();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ConfiguracaoDestinoThrift)
      return this.equals((ConfiguracaoDestinoThrift)that);
    return false;
  }

  public boolean equals(ConfiguracaoDestinoThrift that) {
    if (that == null)
      return false;

    boolean this_present_instalacao = true && this.isSetInstalacao();
    boolean that_present_instalacao = true && that.isSetInstalacao();
    if (this_present_instalacao || that_present_instalacao) {
      if (!(this_present_instalacao && that_present_instalacao))
        return false;
      if (!this.instalacao.equals(that.instalacao))
        return false;
    }

    boolean this_present_uso = true && this.isSetUso();
    boolean that_present_uso = true && that.isSetUso();
    if (this_present_uso || that_present_uso) {
      if (!(this_present_uso && that_present_uso))
        return false;
      if (!this.uso.equals(that.uso))
        return false;
    }

    boolean this_present_versao = true && this.isSetVersao();
    boolean that_present_versao = true && that.isSetVersao();
    if (this_present_versao || that_present_versao) {
      if (!(this_present_versao && that_present_versao))
        return false;
      if (!this.versao.equals(that.versao))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(ConfiguracaoDestinoThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    ConfiguracaoDestinoThrift typedOther = (ConfiguracaoDestinoThrift)other;

    lastComparison = Boolean.valueOf(isSetInstalacao()).compareTo(typedOther.isSetInstalacao());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInstalacao()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.instalacao, typedOther.instalacao);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUso()).compareTo(typedOther.isSetUso());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUso()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uso, typedOther.uso);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetVersao()).compareTo(typedOther.isSetVersao());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVersao()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.versao, typedOther.versao);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ConfiguracaoDestinoThrift(");
    boolean first = true;

    sb.append("instalacao:");
    if (this.instalacao == null) {
      sb.append("null");
    } else {
      sb.append(this.instalacao);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("uso:");
    if (this.uso == null) {
      sb.append("null");
    } else {
      sb.append(this.uso);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("versao:");
    if (this.versao == null) {
      sb.append("null");
    } else {
      sb.append(this.versao);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetInstalacao()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'instalacao' is unset! Struct:" + toString());
    }

    if (!isSetUso()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'uso' is unset! Struct:" + toString());
    }

    if (!isSetVersao()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'versao' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
    if (versao != null) {
      versao.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ConfiguracaoDestinoThriftStandardSchemeFactory implements SchemeFactory {
    public ConfiguracaoDestinoThriftStandardScheme getScheme() {
      return new ConfiguracaoDestinoThriftStandardScheme();
    }
  }

  private static class ConfiguracaoDestinoThriftStandardScheme extends StandardScheme<ConfiguracaoDestinoThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ConfiguracaoDestinoThrift struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // INSTALACAO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.instalacao = TipoInstalacaoDestinoThrift.findByValue(iprot.readI32());
              struct.setInstalacaoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USO
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.uso = TipoUsoDestinoThrift.findByValue(iprot.readI32());
              struct.setUsoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // VERSAO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.versao = new VersaoThrift();
              struct.versao.read(iprot);
              struct.setVersaoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ConfiguracaoDestinoThrift struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.instalacao != null) {
        oprot.writeFieldBegin(INSTALACAO_FIELD_DESC);
        oprot.writeI32(struct.instalacao.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.uso != null) {
        oprot.writeFieldBegin(USO_FIELD_DESC);
        oprot.writeI32(struct.uso.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.versao != null) {
        oprot.writeFieldBegin(VERSAO_FIELD_DESC);
        struct.versao.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ConfiguracaoDestinoThriftTupleSchemeFactory implements SchemeFactory {
    public ConfiguracaoDestinoThriftTupleScheme getScheme() {
      return new ConfiguracaoDestinoThriftTupleScheme();
    }
  }

  private static class ConfiguracaoDestinoThriftTupleScheme extends TupleScheme<ConfiguracaoDestinoThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ConfiguracaoDestinoThrift struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.instalacao.getValue());
      oprot.writeI32(struct.uso.getValue());
      struct.versao.write(oprot);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ConfiguracaoDestinoThrift struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.instalacao = TipoInstalacaoDestinoThrift.findByValue(iprot.readI32());
      struct.setInstalacaoIsSet(true);
      struct.uso = TipoUsoDestinoThrift.findByValue(iprot.readI32());
      struct.setUsoIsSet(true);
      struct.versao = new VersaoThrift();
      struct.versao.read(iprot);
      struct.setVersaoIsSet(true);
    }
  }

}
