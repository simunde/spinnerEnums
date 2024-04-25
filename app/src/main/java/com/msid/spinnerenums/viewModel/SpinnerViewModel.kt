package com.msid.spinnerenums.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpinnerViewModel : ViewModel() {
    enum class SpinnerItem {
        ITEM_ONE,
        ITEM_TWO,
        ITEM_THREE,
        ITEM_FOUR
    }


    val spinnerEnumValues = SpinnerItem.entries.map { it.name }

    val selectedSpinnerItem = MutableLiveData<SpinnerItem>()

    val selectedSpinnerItemValue: SpinnerItem?
        get() = selectedSpinnerItem.value
}