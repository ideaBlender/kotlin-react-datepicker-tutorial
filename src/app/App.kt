package app

import bindings.DatePicker
import react.*
import react.dom.*
import logo.*
import ticker.*
import kotlin.js.Date

interface AppState: RState{
    var pickerDate: Date?
}

class App : RComponent<RProps, AppState>() {
    override fun AppState.init(){
        pickerDate = null
    }

    private fun onPickerChange(date: Date){
        setState {
            pickerDate = date
        }
    }

    override fun RBuilder.render() {
        div("container") {
            div("row"){
                div("col-12"){
                    h1 {
                        +"Kotlin React DatePicker"
                    }
                    if(state.pickerDate == null){
                        p{
                            +"Click the button to pick the date"
                        }
                    } else{
                        p{
                            b{
                                +"You chose: "
                            }
                            +"${state.pickerDate}"
                        }
                    }

                    getDatePickerComponent(::onPickerChange)
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {}
