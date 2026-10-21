package com.parlaktech.headunit4u.aap.protocol.messages

import com.parlaktech.headunit4u.aap.AapMessage
import com.parlaktech.headunit4u.aap.protocol.Channel
import com.parlaktech.headunit4u.aap.protocol.proto.Sensors
import com.google.protobuf.Message

open class SensorEvent(val sensorType: Int, proto: Message)
    : AapMessage(Channel.ID_SEN, Sensors.SensorsMsgType.SENSOR_EVENT_VALUE, proto)
