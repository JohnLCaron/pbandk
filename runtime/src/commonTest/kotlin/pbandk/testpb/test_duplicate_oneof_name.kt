@file:OptIn(pbandk.PublicForGeneratedCode::class)

package pbandk.testpb

@pbandk.Export
public data class Value(
    val value: Value<*>? = null,
    override val unknownFields: Map<Int, pbandk.UnknownField> = emptyMap()
) : pbandk.Message {
    public sealed class Value<V>(value: V) : pbandk.Message.OneOf<V>(value) {
        public class StringValue(stringValue: String = "") : Value<String>(stringValue)
        public class BooleanValue(booleanValue: Boolean = false) : Value<Boolean>(booleanValue)
        public class IntegerValue(integerValue: Int = 0) : Value<Int>(integerValue)
    }

    val stringValue: String?
        get() = (value as? Value.StringValue)?.value
    val booleanValue: Boolean?
        get() = (value as? Value.BooleanValue)?.value
    val integerValue: Int?
        get() = (value as? Value.IntegerValue)?.value

    override operator fun plus(other: pbandk.Message?): pbandk.testpb.Value = protoMergeImpl(other)
    override val descriptor: pbandk.MessageDescriptor<pbandk.testpb.Value> get() = Companion.descriptor
    override val protoSize: Int by lazy { super.protoSize }
    public companion object : pbandk.Message.Companion<pbandk.testpb.Value> {
        public val defaultInstance: pbandk.testpb.Value by lazy { pbandk.testpb.Value() }
        override fun decodeWith(u: pbandk.MessageDecoder): pbandk.testpb.Value = pbandk.testpb.Value.decodeWithImpl(u)

        override val descriptor: pbandk.MessageDescriptor<pbandk.testpb.Value> by lazy {
            val fieldsList = ArrayList<pbandk.FieldDescriptor<pbandk.testpb.Value, *>>(3)
            fieldsList.apply {
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "string_value",
                        number = 1,
                        type = pbandk.FieldDescriptor.Type.Primitive.String(hasPresence = true),
                        oneofMember = true,
                        jsonName = "stringValue",
                        value = pbandk.testpb.Value::stringValue
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "boolean_value",
                        number = 2,
                        type = pbandk.FieldDescriptor.Type.Primitive.Bool(hasPresence = true),
                        oneofMember = true,
                        jsonName = "booleanValue",
                        value = pbandk.testpb.Value::booleanValue
                    )
                )
                add(
                    pbandk.FieldDescriptor(
                        messageDescriptor = this@Companion::descriptor,
                        name = "integer_value",
                        number = 3,
                        type = pbandk.FieldDescriptor.Type.Primitive.Int32(hasPresence = true),
                        oneofMember = true,
                        jsonName = "integerValue",
                        value = pbandk.testpb.Value::integerValue
                    )
                )
            }
            pbandk.MessageDescriptor(
                fullName = "testpb.Value",
                messageClass = pbandk.testpb.Value::class,
                messageCompanion = this,
                fields = fieldsList
            )
        }
    }
}

@pbandk.Export
@pbandk.JsName("orDefaultForValue")
public fun Value?.orDefault(): pbandk.testpb.Value = this ?: Value.defaultInstance

private fun Value.protoMergeImpl(plus: pbandk.Message?): Value = (plus as? Value)?.let {
    it.copy(
        value = plus.value ?: value,
        unknownFields = unknownFields + plus.unknownFields
    )
} ?: this

@Suppress("UNCHECKED_CAST")
private fun Value.Companion.decodeWithImpl(u: pbandk.MessageDecoder): Value {
    var value: Value.Value<*>? = null

    val unknownFields = u.readMessage(this) { _fieldNumber, _fieldValue ->
        when (_fieldNumber) {
            1 -> value = Value.Value.StringValue(_fieldValue as String)
            2 -> value = Value.Value.BooleanValue(_fieldValue as Boolean)
            3 -> value = Value.Value.IntegerValue(_fieldValue as Int)
        }
    }
    return Value(value, unknownFields)
}
