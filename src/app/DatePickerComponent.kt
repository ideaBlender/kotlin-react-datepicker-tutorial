package app

import bindings.DatePicker
import kotlinx.html.js.onClickFunction
import react.*
import react.dom.button
import react.dom.section
import kotlin.js.Date

interface DatePickerComponentProps:RProps{
    var onChangeCB: (date: Date) -> Unit
}

interface DatePickerComponentState:RState{
    var selectedDate:Date
    var pickerOpen:Boolean
}


class DatePickerComponent: RComponent<DatePickerComponentProps, DatePickerComponentState>() {
    override fun DatePickerComponentState.init(){
        selectedDate = Date()
        pickerOpen = false
    }

    private fun handleOnChange(date: Date, event:dynamic){
        setState{
            selectedDate = date
            pickerOpen = !state.pickerOpen
        }
        props.onChangeCB(date)
    }

    override fun RBuilder.render() {
        section {
            if(state.pickerOpen){
                DatePicker{
                    attrs{
                        selected = state.selectedDate
                        onChange = ::handleOnChange
                        withPortal = true
                        inline = true
                    }
                }
            }else{
                button(classes = "btn btn-success") {
                    +"Pick Date"
                    attrs{
                        onClickFunction = {
                            setState{
                                pickerOpen = !state.pickerOpen
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.getDatePickerComponent(onChangeCB: (date: Date) -> Unit) = child(DatePickerComponent::class){
    attrs.onChangeCB = onChangeCB
}