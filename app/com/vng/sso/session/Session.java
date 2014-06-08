/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.vng.sso.session;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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


public class Session implements org.apache.thrift.TBase<Session, Session._Fields>, java.io.Serializable, Cloneable, Comparable<Session> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Session");

  private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("createTime", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField LAST_ACCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("lastAccess", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField UIN_FIELD_DESC = new org.apache.thrift.protocol.TField("uin", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField ZIN_FIELD_DESC = new org.apache.thrift.protocol.TField("zin", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ACCOUNT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("accountName", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField HOSTNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("hostname", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField USERAGENT_FIELD_DESC = new org.apache.thrift.protocol.TField("useragent", org.apache.thrift.protocol.TType.STRING, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SessionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SessionTupleSchemeFactory());
  }

  public int createTime; // required
  public int lastAccess; // required
  public int uin; // required
  public int zin; // required
  public String accountName; // required
  public String hostname; // required
  public String useragent; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CREATE_TIME((short)1, "createTime"),
    LAST_ACCESS((short)2, "lastAccess"),
    UIN((short)3, "uin"),
    ZIN((short)4, "zin"),
    ACCOUNT_NAME((short)5, "accountName"),
    HOSTNAME((short)6, "hostname"),
    USERAGENT((short)7, "useragent");

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
        case 1: // CREATE_TIME
          return CREATE_TIME;
        case 2: // LAST_ACCESS
          return LAST_ACCESS;
        case 3: // UIN
          return UIN;
        case 4: // ZIN
          return ZIN;
        case 5: // ACCOUNT_NAME
          return ACCOUNT_NAME;
        case 6: // HOSTNAME
          return HOSTNAME;
        case 7: // USERAGENT
          return USERAGENT;
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
  private static final int __CREATETIME_ISSET_ID = 0;
  private static final int __LASTACCESS_ISSET_ID = 1;
  private static final int __UIN_ISSET_ID = 2;
  private static final int __ZIN_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CREATE_TIME, new org.apache.thrift.meta_data.FieldMetaData("createTime", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LAST_ACCESS, new org.apache.thrift.meta_data.FieldMetaData("lastAccess", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UIN, new org.apache.thrift.meta_data.FieldMetaData("uin", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ZIN, new org.apache.thrift.meta_data.FieldMetaData("zin", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ACCOUNT_NAME, new org.apache.thrift.meta_data.FieldMetaData("accountName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.HOSTNAME, new org.apache.thrift.meta_data.FieldMetaData("hostname", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USERAGENT, new org.apache.thrift.meta_data.FieldMetaData("useragent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Session.class, metaDataMap);
  }

  public Session() {
  }

  public Session(
    int createTime,
    int lastAccess,
    int uin,
    int zin,
    String accountName,
    String hostname,
    String useragent)
  {
    this();
    this.createTime = createTime;
    setCreateTimeIsSet(true);
    this.lastAccess = lastAccess;
    setLastAccessIsSet(true);
    this.uin = uin;
    setUinIsSet(true);
    this.zin = zin;
    setZinIsSet(true);
    this.accountName = accountName;
    this.hostname = hostname;
    this.useragent = useragent;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Session(Session other) {
    __isset_bitfield = other.__isset_bitfield;
    this.createTime = other.createTime;
    this.lastAccess = other.lastAccess;
    this.uin = other.uin;
    this.zin = other.zin;
    if (other.isSetAccountName()) {
      this.accountName = other.accountName;
    }
    if (other.isSetHostname()) {
      this.hostname = other.hostname;
    }
    if (other.isSetUseragent()) {
      this.useragent = other.useragent;
    }
  }

  public Session deepCopy() {
    return new Session(this);
  }

  @Override
  public void clear() {
    setCreateTimeIsSet(false);
    this.createTime = 0;
    setLastAccessIsSet(false);
    this.lastAccess = 0;
    setUinIsSet(false);
    this.uin = 0;
    setZinIsSet(false);
    this.zin = 0;
    this.accountName = null;
    this.hostname = null;
    this.useragent = null;
  }

  public int getCreateTime() {
    return this.createTime;
  }

  public Session setCreateTime(int createTime) {
    this.createTime = createTime;
    setCreateTimeIsSet(true);
    return this;
  }

  public void unsetCreateTime() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
  }

  /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
  public boolean isSetCreateTime() {
    return EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
  }

  public void setCreateTimeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
  }

  public int getLastAccess() {
    return this.lastAccess;
  }

  public Session setLastAccess(int lastAccess) {
    this.lastAccess = lastAccess;
    setLastAccessIsSet(true);
    return this;
  }

  public void unsetLastAccess() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LASTACCESS_ISSET_ID);
  }

  /** Returns true if field lastAccess is set (has been assigned a value) and false otherwise */
  public boolean isSetLastAccess() {
    return EncodingUtils.testBit(__isset_bitfield, __LASTACCESS_ISSET_ID);
  }

  public void setLastAccessIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LASTACCESS_ISSET_ID, value);
  }

  public int getUin() {
    return this.uin;
  }

  public Session setUin(int uin) {
    this.uin = uin;
    setUinIsSet(true);
    return this;
  }

  public void unsetUin() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __UIN_ISSET_ID);
  }

  /** Returns true if field uin is set (has been assigned a value) and false otherwise */
  public boolean isSetUin() {
    return EncodingUtils.testBit(__isset_bitfield, __UIN_ISSET_ID);
  }

  public void setUinIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __UIN_ISSET_ID, value);
  }

  public int getZin() {
    return this.zin;
  }

  public Session setZin(int zin) {
    this.zin = zin;
    setZinIsSet(true);
    return this;
  }

  public void unsetZin() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ZIN_ISSET_ID);
  }

  /** Returns true if field zin is set (has been assigned a value) and false otherwise */
  public boolean isSetZin() {
    return EncodingUtils.testBit(__isset_bitfield, __ZIN_ISSET_ID);
  }

  public void setZinIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ZIN_ISSET_ID, value);
  }

  public String getAccountName() {
    return this.accountName;
  }

  public Session setAccountName(String accountName) {
    this.accountName = accountName;
    return this;
  }

  public void unsetAccountName() {
    this.accountName = null;
  }

  /** Returns true if field accountName is set (has been assigned a value) and false otherwise */
  public boolean isSetAccountName() {
    return this.accountName != null;
  }

  public void setAccountNameIsSet(boolean value) {
    if (!value) {
      this.accountName = null;
    }
  }

  public String getHostname() {
    return this.hostname;
  }

  public Session setHostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  public void unsetHostname() {
    this.hostname = null;
  }

  /** Returns true if field hostname is set (has been assigned a value) and false otherwise */
  public boolean isSetHostname() {
    return this.hostname != null;
  }

  public void setHostnameIsSet(boolean value) {
    if (!value) {
      this.hostname = null;
    }
  }

  public String getUseragent() {
    return this.useragent;
  }

  public Session setUseragent(String useragent) {
    this.useragent = useragent;
    return this;
  }

  public void unsetUseragent() {
    this.useragent = null;
  }

  /** Returns true if field useragent is set (has been assigned a value) and false otherwise */
  public boolean isSetUseragent() {
    return this.useragent != null;
  }

  public void setUseragentIsSet(boolean value) {
    if (!value) {
      this.useragent = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CREATE_TIME:
      if (value == null) {
        unsetCreateTime();
      } else {
        setCreateTime((Integer)value);
      }
      break;

    case LAST_ACCESS:
      if (value == null) {
        unsetLastAccess();
      } else {
        setLastAccess((Integer)value);
      }
      break;

    case UIN:
      if (value == null) {
        unsetUin();
      } else {
        setUin((Integer)value);
      }
      break;

    case ZIN:
      if (value == null) {
        unsetZin();
      } else {
        setZin((Integer)value);
      }
      break;

    case ACCOUNT_NAME:
      if (value == null) {
        unsetAccountName();
      } else {
        setAccountName((String)value);
      }
      break;

    case HOSTNAME:
      if (value == null) {
        unsetHostname();
      } else {
        setHostname((String)value);
      }
      break;

    case USERAGENT:
      if (value == null) {
        unsetUseragent();
      } else {
        setUseragent((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CREATE_TIME:
      return Integer.valueOf(getCreateTime());

    case LAST_ACCESS:
      return Integer.valueOf(getLastAccess());

    case UIN:
      return Integer.valueOf(getUin());

    case ZIN:
      return Integer.valueOf(getZin());

    case ACCOUNT_NAME:
      return getAccountName();

    case HOSTNAME:
      return getHostname();

    case USERAGENT:
      return getUseragent();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CREATE_TIME:
      return isSetCreateTime();
    case LAST_ACCESS:
      return isSetLastAccess();
    case UIN:
      return isSetUin();
    case ZIN:
      return isSetZin();
    case ACCOUNT_NAME:
      return isSetAccountName();
    case HOSTNAME:
      return isSetHostname();
    case USERAGENT:
      return isSetUseragent();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Session)
      return this.equals((Session)that);
    return false;
  }

  public boolean equals(Session that) {
    if (that == null)
      return false;

    boolean this_present_createTime = true;
    boolean that_present_createTime = true;
    if (this_present_createTime || that_present_createTime) {
      if (!(this_present_createTime && that_present_createTime))
        return false;
      if (this.createTime != that.createTime)
        return false;
    }

    boolean this_present_lastAccess = true;
    boolean that_present_lastAccess = true;
    if (this_present_lastAccess || that_present_lastAccess) {
      if (!(this_present_lastAccess && that_present_lastAccess))
        return false;
      if (this.lastAccess != that.lastAccess)
        return false;
    }

    boolean this_present_uin = true;
    boolean that_present_uin = true;
    if (this_present_uin || that_present_uin) {
      if (!(this_present_uin && that_present_uin))
        return false;
      if (this.uin != that.uin)
        return false;
    }

    boolean this_present_zin = true;
    boolean that_present_zin = true;
    if (this_present_zin || that_present_zin) {
      if (!(this_present_zin && that_present_zin))
        return false;
      if (this.zin != that.zin)
        return false;
    }

    boolean this_present_accountName = true && this.isSetAccountName();
    boolean that_present_accountName = true && that.isSetAccountName();
    if (this_present_accountName || that_present_accountName) {
      if (!(this_present_accountName && that_present_accountName))
        return false;
      if (!this.accountName.equals(that.accountName))
        return false;
    }

    boolean this_present_hostname = true && this.isSetHostname();
    boolean that_present_hostname = true && that.isSetHostname();
    if (this_present_hostname || that_present_hostname) {
      if (!(this_present_hostname && that_present_hostname))
        return false;
      if (!this.hostname.equals(that.hostname))
        return false;
    }

    boolean this_present_useragent = true && this.isSetUseragent();
    boolean that_present_useragent = true && that.isSetUseragent();
    if (this_present_useragent || that_present_useragent) {
      if (!(this_present_useragent && that_present_useragent))
        return false;
      if (!this.useragent.equals(that.useragent))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Session other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetCreateTime()).compareTo(other.isSetCreateTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCreateTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLastAccess()).compareTo(other.isSetLastAccess());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLastAccess()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastAccess, other.lastAccess);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUin()).compareTo(other.isSetUin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.uin, other.uin);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetZin()).compareTo(other.isSetZin());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetZin()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.zin, other.zin);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAccountName()).compareTo(other.isSetAccountName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAccountName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.accountName, other.accountName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHostname()).compareTo(other.isSetHostname());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHostname()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hostname, other.hostname);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUseragent()).compareTo(other.isSetUseragent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUseragent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.useragent, other.useragent);
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
    StringBuilder sb = new StringBuilder("Session(");
    boolean first = true;

    sb.append("createTime:");
    sb.append(this.createTime);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lastAccess:");
    sb.append(this.lastAccess);
    first = false;
    if (!first) sb.append(", ");
    sb.append("uin:");
    sb.append(this.uin);
    first = false;
    if (!first) sb.append(", ");
    sb.append("zin:");
    sb.append(this.zin);
    first = false;
    if (!first) sb.append(", ");
    sb.append("accountName:");
    if (this.accountName == null) {
      sb.append("null");
    } else {
      sb.append(this.accountName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("hostname:");
    if (this.hostname == null) {
      sb.append("null");
    } else {
      sb.append(this.hostname);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("useragent:");
    if (this.useragent == null) {
      sb.append("null");
    } else {
      sb.append(this.useragent);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SessionStandardSchemeFactory implements SchemeFactory {
    public SessionStandardScheme getScheme() {
      return new SessionStandardScheme();
    }
  }

  private static class SessionStandardScheme extends StandardScheme<Session> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Session struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CREATE_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.createTime = iprot.readI32();
              struct.setCreateTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LAST_ACCESS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.lastAccess = iprot.readI32();
              struct.setLastAccessIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UIN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.uin = iprot.readI32();
              struct.setUinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // ZIN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.zin = iprot.readI32();
              struct.setZinIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ACCOUNT_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.accountName = iprot.readString();
              struct.setAccountNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // HOSTNAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.hostname = iprot.readString();
              struct.setHostnameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // USERAGENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.useragent = iprot.readString();
              struct.setUseragentIsSet(true);
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

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Session struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
      oprot.writeI32(struct.createTime);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LAST_ACCESS_FIELD_DESC);
      oprot.writeI32(struct.lastAccess);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(UIN_FIELD_DESC);
      oprot.writeI32(struct.uin);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(ZIN_FIELD_DESC);
      oprot.writeI32(struct.zin);
      oprot.writeFieldEnd();
      if (struct.accountName != null) {
        oprot.writeFieldBegin(ACCOUNT_NAME_FIELD_DESC);
        oprot.writeString(struct.accountName);
        oprot.writeFieldEnd();
      }
      if (struct.hostname != null) {
        oprot.writeFieldBegin(HOSTNAME_FIELD_DESC);
        oprot.writeString(struct.hostname);
        oprot.writeFieldEnd();
      }
      if (struct.useragent != null) {
        oprot.writeFieldBegin(USERAGENT_FIELD_DESC);
        oprot.writeString(struct.useragent);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SessionTupleSchemeFactory implements SchemeFactory {
    public SessionTupleScheme getScheme() {
      return new SessionTupleScheme();
    }
  }

  private static class SessionTupleScheme extends TupleScheme<Session> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Session struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetCreateTime()) {
        optionals.set(0);
      }
      if (struct.isSetLastAccess()) {
        optionals.set(1);
      }
      if (struct.isSetUin()) {
        optionals.set(2);
      }
      if (struct.isSetZin()) {
        optionals.set(3);
      }
      if (struct.isSetAccountName()) {
        optionals.set(4);
      }
      if (struct.isSetHostname()) {
        optionals.set(5);
      }
      if (struct.isSetUseragent()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetCreateTime()) {
        oprot.writeI32(struct.createTime);
      }
      if (struct.isSetLastAccess()) {
        oprot.writeI32(struct.lastAccess);
      }
      if (struct.isSetUin()) {
        oprot.writeI32(struct.uin);
      }
      if (struct.isSetZin()) {
        oprot.writeI32(struct.zin);
      }
      if (struct.isSetAccountName()) {
        oprot.writeString(struct.accountName);
      }
      if (struct.isSetHostname()) {
        oprot.writeString(struct.hostname);
      }
      if (struct.isSetUseragent()) {
        oprot.writeString(struct.useragent);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Session struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.createTime = iprot.readI32();
        struct.setCreateTimeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.lastAccess = iprot.readI32();
        struct.setLastAccessIsSet(true);
      }
      if (incoming.get(2)) {
        struct.uin = iprot.readI32();
        struct.setUinIsSet(true);
      }
      if (incoming.get(3)) {
        struct.zin = iprot.readI32();
        struct.setZinIsSet(true);
      }
      if (incoming.get(4)) {
        struct.accountName = iprot.readString();
        struct.setAccountNameIsSet(true);
      }
      if (incoming.get(5)) {
        struct.hostname = iprot.readString();
        struct.setHostnameIsSet(true);
      }
      if (incoming.get(6)) {
        struct.useragent = iprot.readString();
        struct.setUseragentIsSet(true);
      }
    }
  }

}

