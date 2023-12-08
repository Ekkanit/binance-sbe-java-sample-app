/* Generated SBE (Simple Binary Encoding) message codec. */
package spot_sbe;

import org.agrona.MutableDirectBuffer;
import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public final class OrdersResponseDecoder
{
    public static final int BLOCK_LENGTH = 0;
    public static final int TEMPLATE_ID = 308;
    public static final int SCHEMA_ID = 1;
    public static final int SCHEMA_VERSION = 0;
    public static final String SEMANTIC_VERSION = "5.2";
    public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

    private final OrdersResponseDecoder parentMessage = this;
    private DirectBuffer buffer;
    private int initialOffset;
    private int offset;
    private int limit;
    int actingBlockLength;
    int actingVersion;

    public int sbeBlockLength()
    {
        return BLOCK_LENGTH;
    }

    public int sbeTemplateId()
    {
        return TEMPLATE_ID;
    }

    public int sbeSchemaId()
    {
        return SCHEMA_ID;
    }

    public int sbeSchemaVersion()
    {
        return SCHEMA_VERSION;
    }

    public String sbeSemanticType()
    {
        return "";
    }

    public DirectBuffer buffer()
    {
        return buffer;
    }

    public int initialOffset()
    {
        return initialOffset;
    }

    public int offset()
    {
        return offset;
    }

    public OrdersResponseDecoder wrap(
        final DirectBuffer buffer,
        final int offset,
        final int actingBlockLength,
        final int actingVersion)
    {
        if (buffer != this.buffer)
        {
            this.buffer = buffer;
        }
        this.initialOffset = offset;
        this.offset = offset;
        this.actingBlockLength = actingBlockLength;
        this.actingVersion = actingVersion;
        limit(offset + actingBlockLength);

        return this;
    }

    public OrdersResponseDecoder wrapAndApplyHeader(
        final DirectBuffer buffer,
        final int offset,
        final MessageHeaderDecoder headerDecoder)
    {
        headerDecoder.wrap(buffer, offset);

        final int templateId = headerDecoder.templateId();
        if (TEMPLATE_ID != templateId)
        {
            throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
        }

        return wrap(
            buffer,
            offset + MessageHeaderDecoder.ENCODED_LENGTH,
            headerDecoder.blockLength(),
            headerDecoder.version());
    }

    public OrdersResponseDecoder sbeRewind()
    {
        return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
    }

    public int sbeDecodedLength()
    {
        final int currentLimit = limit();
        sbeSkip();
        final int decodedLength = encodedLength();
        limit(currentLimit);

        return decodedLength;
    }

    public int actingVersion()
    {
        return actingVersion;
    }

    public int encodedLength()
    {
        return limit - offset;
    }

    public int limit()
    {
        return limit;
    }

    public void limit(final int limit)
    {
        this.limit = limit;
    }

    private final OrdersDecoder orders = new OrdersDecoder(this);

    public static long ordersDecoderId()
    {
        return 100;
    }

    public static int ordersDecoderSinceVersion()
    {
        return 0;
    }

    public OrdersDecoder orders()
    {
        orders.wrap(buffer);
        return orders;
    }

    public static final class OrdersDecoder
        implements Iterable<OrdersDecoder>, java.util.Iterator<OrdersDecoder>
    {
        public static final int HEADER_SIZE = 6;
        private final OrdersResponseDecoder parentMessage;
        private DirectBuffer buffer;
        private int count;
        private int index;
        private int offset;
        private int blockLength;

        OrdersDecoder(final OrdersResponseDecoder parentMessage)
        {
            this.parentMessage = parentMessage;
        }

        public void wrap(final DirectBuffer buffer)
        {
            if (buffer != this.buffer)
            {
                this.buffer = buffer;
            }

            index = 0;
            final int limit = parentMessage.limit();
            parentMessage.limit(limit + HEADER_SIZE);
            blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
            count = (int)(buffer.getInt(limit + 2, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
        }

        public OrdersDecoder next()
        {
            if (index >= count)
            {
                throw new java.util.NoSuchElementException();
            }

            offset = parentMessage.limit();
            parentMessage.limit(offset + blockLength);
            ++index;

            return this;
        }

        public static long countMinValue()
        {
            return 0L;
        }

        public static long countMaxValue()
        {
            return 2147483647L;
        }

        public static int sbeHeaderSize()
        {
            return HEADER_SIZE;
        }

        public static int sbeBlockLength()
        {
            return 151;
        }

        public int actingBlockLength()
        {
            return blockLength;
        }

        public int count()
        {
            return count;
        }

        public java.util.Iterator<OrdersDecoder> iterator()
        {
            return this;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext()
        {
            return index < count;
        }

        public static int priceExponentId()
        {
            return 1;
        }

        public static int priceExponentSinceVersion()
        {
            return 0;
        }

        public static int priceExponentEncodingOffset()
        {
            return 0;
        }

        public static int priceExponentEncodingLength()
        {
            return 1;
        }

        public static String priceExponentMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static byte priceExponentNullValue()
        {
            return (byte)-128;
        }

        public static byte priceExponentMinValue()
        {
            return (byte)-127;
        }

        public static byte priceExponentMaxValue()
        {
            return (byte)127;
        }

        public byte priceExponent()
        {
            return buffer.getByte(offset + 0);
        }


        public static int qtyExponentId()
        {
            return 2;
        }

        public static int qtyExponentSinceVersion()
        {
            return 0;
        }

        public static int qtyExponentEncodingOffset()
        {
            return 1;
        }

        public static int qtyExponentEncodingLength()
        {
            return 1;
        }

        public static String qtyExponentMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static byte qtyExponentNullValue()
        {
            return (byte)-128;
        }

        public static byte qtyExponentMinValue()
        {
            return (byte)-127;
        }

        public static byte qtyExponentMaxValue()
        {
            return (byte)127;
        }

        public byte qtyExponent()
        {
            return buffer.getByte(offset + 1);
        }


        public static int orderIdId()
        {
            return 3;
        }

        public static int orderIdSinceVersion()
        {
            return 0;
        }

        public static int orderIdEncodingOffset()
        {
            return 2;
        }

        public static int orderIdEncodingLength()
        {
            return 8;
        }

        public static String orderIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long orderIdNullValue()
        {
            return -9223372036854775808L;
        }

        public static long orderIdMinValue()
        {
            return -9223372036854775807L;
        }

        public static long orderIdMaxValue()
        {
            return 9223372036854775807L;
        }

        public long orderId()
        {
            return buffer.getLong(offset + 2, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int orderListIdId()
        {
            return 4;
        }

        public static int orderListIdSinceVersion()
        {
            return 0;
        }

        public static int orderListIdEncodingOffset()
        {
            return 10;
        }

        public static int orderListIdEncodingLength()
        {
            return 8;
        }

        public static String orderListIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long orderListIdNullValue()
        {
            return -9223372036854775808L;
        }

        public static long orderListIdMinValue()
        {
            return -9223372036854775807L;
        }

        public static long orderListIdMaxValue()
        {
            return 9223372036854775807L;
        }

        public long orderListId()
        {
            return buffer.getLong(offset + 10, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int priceId()
        {
            return 5;
        }

        public static int priceSinceVersion()
        {
            return 0;
        }

        public static int priceEncodingOffset()
        {
            return 18;
        }

        public static int priceEncodingLength()
        {
            return 8;
        }

        public static String priceMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long priceNullValue()
        {
            return -9223372036854775808L;
        }

        public static long priceMinValue()
        {
            return -9223372036854775807L;
        }

        public static long priceMaxValue()
        {
            return 9223372036854775807L;
        }

        public long price()
        {
            return buffer.getLong(offset + 18, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int origQtyId()
        {
            return 6;
        }

        public static int origQtySinceVersion()
        {
            return 0;
        }

        public static int origQtyEncodingOffset()
        {
            return 26;
        }

        public static int origQtyEncodingLength()
        {
            return 8;
        }

        public static String origQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long origQtyNullValue()
        {
            return -9223372036854775808L;
        }

        public static long origQtyMinValue()
        {
            return -9223372036854775807L;
        }

        public static long origQtyMaxValue()
        {
            return 9223372036854775807L;
        }

        public long origQty()
        {
            return buffer.getLong(offset + 26, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int executedQtyId()
        {
            return 7;
        }

        public static int executedQtySinceVersion()
        {
            return 0;
        }

        public static int executedQtyEncodingOffset()
        {
            return 34;
        }

        public static int executedQtyEncodingLength()
        {
            return 8;
        }

        public static String executedQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long executedQtyNullValue()
        {
            return -9223372036854775808L;
        }

        public static long executedQtyMinValue()
        {
            return -9223372036854775807L;
        }

        public static long executedQtyMaxValue()
        {
            return 9223372036854775807L;
        }

        public long executedQty()
        {
            return buffer.getLong(offset + 34, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int cummulativeQuoteQtyId()
        {
            return 8;
        }

        public static int cummulativeQuoteQtySinceVersion()
        {
            return 0;
        }

        public static int cummulativeQuoteQtyEncodingOffset()
        {
            return 42;
        }

        public static int cummulativeQuoteQtyEncodingLength()
        {
            return 8;
        }

        public static String cummulativeQuoteQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long cummulativeQuoteQtyNullValue()
        {
            return -9223372036854775808L;
        }

        public static long cummulativeQuoteQtyMinValue()
        {
            return -9223372036854775807L;
        }

        public static long cummulativeQuoteQtyMaxValue()
        {
            return 9223372036854775807L;
        }

        public long cummulativeQuoteQty()
        {
            return buffer.getLong(offset + 42, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int statusId()
        {
            return 9;
        }

        public static int statusSinceVersion()
        {
            return 0;
        }

        public static int statusEncodingOffset()
        {
            return 50;
        }

        public static int statusEncodingLength()
        {
            return 1;
        }

        public static String statusMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short statusRaw()
        {
            return ((short)(buffer.getByte(offset + 50) & 0xFF));
        }

        public OrderStatus status()
        {
            return OrderStatus.get(((short)(buffer.getByte(offset + 50) & 0xFF)));
        }


        public static int timeInForceId()
        {
            return 10;
        }

        public static int timeInForceSinceVersion()
        {
            return 0;
        }

        public static int timeInForceEncodingOffset()
        {
            return 51;
        }

        public static int timeInForceEncodingLength()
        {
            return 1;
        }

        public static String timeInForceMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short timeInForceRaw()
        {
            return ((short)(buffer.getByte(offset + 51) & 0xFF));
        }

        public TimeInForce timeInForce()
        {
            return TimeInForce.get(((short)(buffer.getByte(offset + 51) & 0xFF)));
        }


        public static int orderTypeId()
        {
            return 11;
        }

        public static int orderTypeSinceVersion()
        {
            return 0;
        }

        public static int orderTypeEncodingOffset()
        {
            return 52;
        }

        public static int orderTypeEncodingLength()
        {
            return 1;
        }

        public static String orderTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short orderTypeRaw()
        {
            return ((short)(buffer.getByte(offset + 52) & 0xFF));
        }

        public OrderType orderType()
        {
            return OrderType.get(((short)(buffer.getByte(offset + 52) & 0xFF)));
        }


        public static int sideId()
        {
            return 12;
        }

        public static int sideSinceVersion()
        {
            return 0;
        }

        public static int sideEncodingOffset()
        {
            return 53;
        }

        public static int sideEncodingLength()
        {
            return 1;
        }

        public static String sideMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short sideRaw()
        {
            return ((short)(buffer.getByte(offset + 53) & 0xFF));
        }

        public OrderSide side()
        {
            return OrderSide.get(((short)(buffer.getByte(offset + 53) & 0xFF)));
        }


        public static int stopPriceId()
        {
            return 13;
        }

        public static int stopPriceSinceVersion()
        {
            return 0;
        }

        public static int stopPriceEncodingOffset()
        {
            return 54;
        }

        public static int stopPriceEncodingLength()
        {
            return 8;
        }

        public static String stopPriceMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long stopPriceNullValue()
        {
            return -9223372036854775808L;
        }

        public static long stopPriceMinValue()
        {
            return -9223372036854775807L;
        }

        public static long stopPriceMaxValue()
        {
            return 9223372036854775807L;
        }

        public long stopPrice()
        {
            return buffer.getLong(offset + 54, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int trailingDeltaId()
        {
            return 14;
        }

        public static int trailingDeltaSinceVersion()
        {
            return 0;
        }

        public static int trailingDeltaEncodingOffset()
        {
            return 62;
        }

        public static int trailingDeltaEncodingLength()
        {
            return 8;
        }

        public static String trailingDeltaMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long trailingDeltaNullValue()
        {
            return -9223372036854775808L;
        }

        public static long trailingDeltaMinValue()
        {
            return -9223372036854775807L;
        }

        public static long trailingDeltaMaxValue()
        {
            return 9223372036854775807L;
        }

        public long trailingDelta()
        {
            return buffer.getLong(offset + 62, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int trailingTimeId()
        {
            return 15;
        }

        public static int trailingTimeSinceVersion()
        {
            return 0;
        }

        public static int trailingTimeEncodingOffset()
        {
            return 70;
        }

        public static int trailingTimeEncodingLength()
        {
            return 8;
        }

        public static String trailingTimeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long trailingTimeNullValue()
        {
            return -9223372036854775808L;
        }

        public static long trailingTimeMinValue()
        {
            return -9223372036854775807L;
        }

        public static long trailingTimeMaxValue()
        {
            return 9223372036854775807L;
        }

        public long trailingTime()
        {
            return buffer.getLong(offset + 70, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int icebergQtyId()
        {
            return 16;
        }

        public static int icebergQtySinceVersion()
        {
            return 0;
        }

        public static int icebergQtyEncodingOffset()
        {
            return 78;
        }

        public static int icebergQtyEncodingLength()
        {
            return 8;
        }

        public static String icebergQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long icebergQtyNullValue()
        {
            return -9223372036854775808L;
        }

        public static long icebergQtyMinValue()
        {
            return -9223372036854775807L;
        }

        public static long icebergQtyMaxValue()
        {
            return 9223372036854775807L;
        }

        public long icebergQty()
        {
            return buffer.getLong(offset + 78, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int timeId()
        {
            return 17;
        }

        public static int timeSinceVersion()
        {
            return 0;
        }

        public static int timeEncodingOffset()
        {
            return 86;
        }

        public static int timeEncodingLength()
        {
            return 8;
        }

        public static String timeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long timeNullValue()
        {
            return -9223372036854775808L;
        }

        public static long timeMinValue()
        {
            return -9223372036854775807L;
        }

        public static long timeMaxValue()
        {
            return 9223372036854775807L;
        }

        public long time()
        {
            return buffer.getLong(offset + 86, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int updateTimeId()
        {
            return 18;
        }

        public static int updateTimeSinceVersion()
        {
            return 0;
        }

        public static int updateTimeEncodingOffset()
        {
            return 94;
        }

        public static int updateTimeEncodingLength()
        {
            return 8;
        }

        public static String updateTimeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long updateTimeNullValue()
        {
            return -9223372036854775808L;
        }

        public static long updateTimeMinValue()
        {
            return -9223372036854775807L;
        }

        public static long updateTimeMaxValue()
        {
            return 9223372036854775807L;
        }

        public long updateTime()
        {
            return buffer.getLong(offset + 94, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int isWorkingId()
        {
            return 19;
        }

        public static int isWorkingSinceVersion()
        {
            return 0;
        }

        public static int isWorkingEncodingOffset()
        {
            return 102;
        }

        public static int isWorkingEncodingLength()
        {
            return 1;
        }

        public static String isWorkingMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short isWorkingRaw()
        {
            return ((short)(buffer.getByte(offset + 102) & 0xFF));
        }

        public BoolEnum isWorking()
        {
            return BoolEnum.get(((short)(buffer.getByte(offset + 102) & 0xFF)));
        }


        public static int workingTimeId()
        {
            return 20;
        }

        public static int workingTimeSinceVersion()
        {
            return 0;
        }

        public static int workingTimeEncodingOffset()
        {
            return 103;
        }

        public static int workingTimeEncodingLength()
        {
            return 8;
        }

        public static String workingTimeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long workingTimeNullValue()
        {
            return -9223372036854775808L;
        }

        public static long workingTimeMinValue()
        {
            return -9223372036854775807L;
        }

        public static long workingTimeMaxValue()
        {
            return 9223372036854775807L;
        }

        public long workingTime()
        {
            return buffer.getLong(offset + 103, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int origQuoteOrderQtyId()
        {
            return 21;
        }

        public static int origQuoteOrderQtySinceVersion()
        {
            return 0;
        }

        public static int origQuoteOrderQtyEncodingOffset()
        {
            return 111;
        }

        public static int origQuoteOrderQtyEncodingLength()
        {
            return 8;
        }

        public static String origQuoteOrderQtyMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static long origQuoteOrderQtyNullValue()
        {
            return -9223372036854775808L;
        }

        public static long origQuoteOrderQtyMinValue()
        {
            return -9223372036854775807L;
        }

        public static long origQuoteOrderQtyMaxValue()
        {
            return 9223372036854775807L;
        }

        public long origQuoteOrderQty()
        {
            return buffer.getLong(offset + 111, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int strategyIdId()
        {
            return 22;
        }

        public static int strategyIdSinceVersion()
        {
            return 0;
        }

        public static int strategyIdEncodingOffset()
        {
            return 119;
        }

        public static int strategyIdEncodingLength()
        {
            return 8;
        }

        public static String strategyIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long strategyIdNullValue()
        {
            return -9223372036854775808L;
        }

        public static long strategyIdMinValue()
        {
            return -9223372036854775807L;
        }

        public static long strategyIdMaxValue()
        {
            return 9223372036854775807L;
        }

        public long strategyId()
        {
            return buffer.getLong(offset + 119, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int strategyTypeId()
        {
            return 23;
        }

        public static int strategyTypeSinceVersion()
        {
            return 0;
        }

        public static int strategyTypeEncodingOffset()
        {
            return 127;
        }

        public static int strategyTypeEncodingLength()
        {
            return 4;
        }

        public static String strategyTypeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static int strategyTypeNullValue()
        {
            return -2147483648;
        }

        public static int strategyTypeMinValue()
        {
            return -2147483647;
        }

        public static int strategyTypeMaxValue()
        {
            return 2147483647;
        }

        public int strategyType()
        {
            return buffer.getInt(offset + 127, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int orderCapacityId()
        {
            return 24;
        }

        public static int orderCapacitySinceVersion()
        {
            return 0;
        }

        public static int orderCapacityEncodingOffset()
        {
            return 131;
        }

        public static int orderCapacityEncodingLength()
        {
            return 1;
        }

        public static String orderCapacityMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public short orderCapacityRaw()
        {
            return ((short)(buffer.getByte(offset + 131) & 0xFF));
        }

        public OrderCapacity orderCapacity()
        {
            return OrderCapacity.get(((short)(buffer.getByte(offset + 131) & 0xFF)));
        }


        public static int workingFloorId()
        {
            return 25;
        }

        public static int workingFloorSinceVersion()
        {
            return 0;
        }

        public static int workingFloorEncodingOffset()
        {
            return 132;
        }

        public static int workingFloorEncodingLength()
        {
            return 1;
        }

        public static String workingFloorMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public short workingFloorRaw()
        {
            return ((short)(buffer.getByte(offset + 132) & 0xFF));
        }

        public Floor workingFloor()
        {
            return Floor.get(((short)(buffer.getByte(offset + 132) & 0xFF)));
        }


        public static int selfTradePreventionModeId()
        {
            return 26;
        }

        public static int selfTradePreventionModeSinceVersion()
        {
            return 0;
        }

        public static int selfTradePreventionModeEncodingOffset()
        {
            return 133;
        }

        public static int selfTradePreventionModeEncodingLength()
        {
            return 1;
        }

        public static String selfTradePreventionModeMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public short selfTradePreventionModeRaw()
        {
            return ((short)(buffer.getByte(offset + 133) & 0xFF));
        }

        public SelfTradePreventionMode selfTradePreventionMode()
        {
            return SelfTradePreventionMode.get(((short)(buffer.getByte(offset + 133) & 0xFF)));
        }


        public static int preventedMatchIdId()
        {
            return 27;
        }

        public static int preventedMatchIdSinceVersion()
        {
            return 0;
        }

        public static int preventedMatchIdEncodingOffset()
        {
            return 134;
        }

        public static int preventedMatchIdEncodingLength()
        {
            return 8;
        }

        public static String preventedMatchIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long preventedMatchIdNullValue()
        {
            return -9223372036854775808L;
        }

        public static long preventedMatchIdMinValue()
        {
            return -9223372036854775807L;
        }

        public static long preventedMatchIdMaxValue()
        {
            return 9223372036854775807L;
        }

        public long preventedMatchId()
        {
            return buffer.getLong(offset + 134, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int preventedQuantityId()
        {
            return 28;
        }

        public static int preventedQuantitySinceVersion()
        {
            return 0;
        }

        public static int preventedQuantityEncodingOffset()
        {
            return 142;
        }

        public static int preventedQuantityEncodingLength()
        {
            return 8;
        }

        public static String preventedQuantityMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public static long preventedQuantityNullValue()
        {
            return -9223372036854775808L;
        }

        public static long preventedQuantityMinValue()
        {
            return -9223372036854775807L;
        }

        public static long preventedQuantityMaxValue()
        {
            return 9223372036854775807L;
        }

        public long preventedQuantity()
        {
            return buffer.getLong(offset + 142, java.nio.ByteOrder.LITTLE_ENDIAN);
        }


        public static int usedSorId()
        {
            return 29;
        }

        public static int usedSorSinceVersion()
        {
            return 0;
        }

        public static int usedSorEncodingOffset()
        {
            return 150;
        }

        public static int usedSorEncodingLength()
        {
            return 1;
        }

        public static String usedSorMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "optional";
            }

            return "";
        }

        public short usedSorRaw()
        {
            return ((short)(buffer.getByte(offset + 150) & 0xFF));
        }

        public BoolEnum usedSor()
        {
            return BoolEnum.get(((short)(buffer.getByte(offset + 150) & 0xFF)));
        }


        public static int symbolId()
        {
            return 200;
        }

        public static int symbolSinceVersion()
        {
            return 0;
        }

        public static String symbolCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.UTF_8.name();
        }

        public static String symbolMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static int symbolHeaderLength()
        {
            return 1;
        }

        public int symbolLength()
        {
            final int limit = parentMessage.limit();
            return ((short)(buffer.getByte(limit) & 0xFF));
        }

        public int skipSymbol()
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int dataOffset = limit + headerLength;
            parentMessage.limit(dataOffset + dataLength);

            return dataLength;
        }

        public int getSymbol(final MutableDirectBuffer dst, final int dstOffset, final int length)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }

        public int getSymbol(final byte[] dst, final int dstOffset, final int length)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }

        public void wrapSymbol(final DirectBuffer wrapBuffer)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            parentMessage.limit(limit + headerLength + dataLength);
            wrapBuffer.wrap(buffer, limit + headerLength, dataLength);
        }

        public String symbol()
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            parentMessage.limit(limit + headerLength + dataLength);

            if (0 == dataLength)
            {
                return "";
            }

            final byte[] tmp = new byte[dataLength];
            buffer.getBytes(limit + headerLength, tmp, 0, dataLength);

            return new String(tmp, java.nio.charset.StandardCharsets.UTF_8);
        }

        public static int clientOrderIdId()
        {
            return 201;
        }

        public static int clientOrderIdSinceVersion()
        {
            return 0;
        }

        public static String clientOrderIdCharacterEncoding()
        {
            return java.nio.charset.StandardCharsets.UTF_8.name();
        }

        public static String clientOrderIdMetaAttribute(final MetaAttribute metaAttribute)
        {
            if (MetaAttribute.PRESENCE == metaAttribute)
            {
                return "required";
            }

            return "";
        }

        public static int clientOrderIdHeaderLength()
        {
            return 1;
        }

        public int clientOrderIdLength()
        {
            final int limit = parentMessage.limit();
            return ((short)(buffer.getByte(limit) & 0xFF));
        }

        public int skipClientOrderId()
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int dataOffset = limit + headerLength;
            parentMessage.limit(dataOffset + dataLength);

            return dataLength;
        }

        public int getClientOrderId(final MutableDirectBuffer dst, final int dstOffset, final int length)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }

        public int getClientOrderId(final byte[] dst, final int dstOffset, final int length)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            final int bytesCopied = Math.min(length, dataLength);
            parentMessage.limit(limit + headerLength + dataLength);
            buffer.getBytes(limit + headerLength, dst, dstOffset, bytesCopied);

            return bytesCopied;
        }

        public void wrapClientOrderId(final DirectBuffer wrapBuffer)
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            parentMessage.limit(limit + headerLength + dataLength);
            wrapBuffer.wrap(buffer, limit + headerLength, dataLength);
        }

        public String clientOrderId()
        {
            final int headerLength = 1;
            final int limit = parentMessage.limit();
            final int dataLength = ((short)(buffer.getByte(limit) & 0xFF));
            parentMessage.limit(limit + headerLength + dataLength);

            if (0 == dataLength)
            {
                return "";
            }

            final byte[] tmp = new byte[dataLength];
            buffer.getBytes(limit + headerLength, tmp, 0, dataLength);

            return new String(tmp, java.nio.charset.StandardCharsets.UTF_8);
        }

        public StringBuilder appendTo(final StringBuilder builder)
        {
            if (null == buffer)
            {
                return builder;
            }

            builder.append('(');
            builder.append("priceExponent=");
            builder.append(this.priceExponent());
            builder.append('|');
            builder.append("qtyExponent=");
            builder.append(this.qtyExponent());
            builder.append('|');
            builder.append("orderId=");
            builder.append(this.orderId());
            builder.append('|');
            builder.append("orderListId=");
            builder.append(this.orderListId());
            builder.append('|');
            builder.append("price=");
            builder.append(this.price());
            builder.append('|');
            builder.append("origQty=");
            builder.append(this.origQty());
            builder.append('|');
            builder.append("executedQty=");
            builder.append(this.executedQty());
            builder.append('|');
            builder.append("cummulativeQuoteQty=");
            builder.append(this.cummulativeQuoteQty());
            builder.append('|');
            builder.append("status=");
            builder.append(this.status());
            builder.append('|');
            builder.append("timeInForce=");
            builder.append(this.timeInForce());
            builder.append('|');
            builder.append("orderType=");
            builder.append(this.orderType());
            builder.append('|');
            builder.append("side=");
            builder.append(this.side());
            builder.append('|');
            builder.append("stopPrice=");
            builder.append(this.stopPrice());
            builder.append('|');
            builder.append("trailingDelta=");
            builder.append(this.trailingDelta());
            builder.append('|');
            builder.append("trailingTime=");
            builder.append(this.trailingTime());
            builder.append('|');
            builder.append("icebergQty=");
            builder.append(this.icebergQty());
            builder.append('|');
            builder.append("time=");
            builder.append(this.time());
            builder.append('|');
            builder.append("updateTime=");
            builder.append(this.updateTime());
            builder.append('|');
            builder.append("isWorking=");
            builder.append(this.isWorking());
            builder.append('|');
            builder.append("workingTime=");
            builder.append(this.workingTime());
            builder.append('|');
            builder.append("origQuoteOrderQty=");
            builder.append(this.origQuoteOrderQty());
            builder.append('|');
            builder.append("strategyId=");
            builder.append(this.strategyId());
            builder.append('|');
            builder.append("strategyType=");
            builder.append(this.strategyType());
            builder.append('|');
            builder.append("orderCapacity=");
            builder.append(this.orderCapacity());
            builder.append('|');
            builder.append("workingFloor=");
            builder.append(this.workingFloor());
            builder.append('|');
            builder.append("selfTradePreventionMode=");
            builder.append(this.selfTradePreventionMode());
            builder.append('|');
            builder.append("preventedMatchId=");
            builder.append(this.preventedMatchId());
            builder.append('|');
            builder.append("preventedQuantity=");
            builder.append(this.preventedQuantity());
            builder.append('|');
            builder.append("usedSor=");
            builder.append(this.usedSor());
            builder.append('|');
            builder.append("symbol=");
            builder.append('\'').append(symbol()).append('\'');
            builder.append('|');
            builder.append("clientOrderId=");
            builder.append('\'').append(clientOrderId()).append('\'');
            builder.append(')');

            return builder;
        }
        
        public OrdersDecoder sbeSkip()
        {
            skipSymbol();
            skipClientOrderId();

            return this;
        }
    }

    public String toString()
    {
        if (null == buffer)
        {
            return "";
        }

        final OrdersResponseDecoder decoder = new OrdersResponseDecoder();
        decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

        return decoder.appendTo(new StringBuilder()).toString();
    }

    public StringBuilder appendTo(final StringBuilder builder)
    {
        if (null == buffer)
        {
            return builder;
        }

        final int originalLimit = limit();
        limit(initialOffset + actingBlockLength);
        builder.append("[OrdersResponse](sbeTemplateId=");
        builder.append(TEMPLATE_ID);
        builder.append("|sbeSchemaId=");
        builder.append(SCHEMA_ID);
        builder.append("|sbeSchemaVersion=");
        if (parentMessage.actingVersion != SCHEMA_VERSION)
        {
            builder.append(parentMessage.actingVersion);
            builder.append('/');
        }
        builder.append(SCHEMA_VERSION);
        builder.append("|sbeBlockLength=");
        if (actingBlockLength != BLOCK_LENGTH)
        {
            builder.append(actingBlockLength);
            builder.append('/');
        }
        builder.append(BLOCK_LENGTH);
        builder.append("):");
        builder.append("orders=[");
        final int ordersOriginalOffset = orders.offset;
        final int ordersOriginalIndex = orders.index;
        final OrdersDecoder orders = this.orders();
        if (orders.count() > 0)
        {
            while (orders.hasNext())
            {
                orders.next().appendTo(builder);
                builder.append(',');
            }
            builder.setLength(builder.length() - 1);
        }
        orders.offset = ordersOriginalOffset;
        orders.index = ordersOriginalIndex;
        builder.append(']');

        limit(originalLimit);

        return builder;
    }
    
    public OrdersResponseDecoder sbeSkip()
    {
        sbeRewind();
        OrdersDecoder orders = this.orders();
        if (orders.count() > 0)
        {
            while (orders.hasNext())
            {
                orders.next();
                orders.sbeSkip();
            }
        }

        return this;
    }
}