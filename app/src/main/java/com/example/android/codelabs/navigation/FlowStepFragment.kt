/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs

/**
 * Presents how multiple steps flow could be implemented.
 */
class FlowStepFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val safeArgs: FlowStepFragmentArgs by navArgs()
        Log.d("tfandkusu", "FlowStepFragment#onCreate " + safeArgs.flowStepNumber)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

//        val flowStepNumber = arguments?.getInt("flowStepNumber")

        // TODO STEP 8 - Use type-safe arguments - remove previous line!
        val safeArgs: FlowStepFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber
        // TODO END STEP 8

        return when (flowStepNumber) {
            2 -> inflater.inflate(R.layout.flow_step_two_fragment, container, false)
            else -> inflater.inflate(R.layout.flow_step_one_fragment, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
        * 遷移先にactionを指定できる。actionはエディターに矢印が出るし、アニメーション設定も可能
        * */
        view.findViewById<View>(R.id.next_button).setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.next_action)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        val safeArgs: FlowStepFragmentArgs by navArgs()
        Log.d("tfandkusu", "FlowStepFragment#onDestroy "  + safeArgs.flowStepNumber)
    }
}
