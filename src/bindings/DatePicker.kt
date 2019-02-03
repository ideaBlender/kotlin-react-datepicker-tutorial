@file:JsModule("react-datepicker")

package bindings

import react.RClass
import react.RProps
import kotlin.js.Date

@JsName("default")
external val DatePicker:RClass<DatePickerProps>

external interface DatePickerProps: RProps{
    var onChange: (date: Date, event:dynamic) -> Unit
    var selected: Date?
    var withPortal: Boolean?
    var inline: Boolean?
}