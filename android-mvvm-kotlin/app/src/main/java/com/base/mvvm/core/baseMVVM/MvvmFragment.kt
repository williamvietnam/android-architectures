package com.base.mvvm.core.baseMVVM

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.base.mvvm.R
import com.base.mvvm.core.widget.WidgetProgressDialog
import com.google.android.material.snackbar.Snackbar

abstract class MvvmFragment<VB : ViewBinding> : Fragment(), MvvmFragmentView {

    private var _binding: VB? = null
    val binding get() = _binding!!

    private lateinit var progressDialog: WidgetProgressDialog
    private var errorPopup: AlertDialog? = null

    abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.progressDialog = WidgetProgressDialog(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    override fun screenBack() {
        activity?.onBackPressed()
    }

    override fun showProgressDialog(isShow: Boolean) {
        if (isShow) {
            showProgress()
        } else {
            dismissProgress()
        }
    }

    private fun showProgress() {
        if (!progressDialog.isShowing) progressDialog.show()
    }

    private fun dismissProgress() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }

    override fun showSnackBar(resId: Int) {
        Snackbar.make(binding.root, resId, Snackbar.LENGTH_LONG).show()
    }

    override fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }

    override fun showWarningDialog(resId: Int) {
        showWarningDialog(getString(resId))
    }

    override fun showWarningDialog(msg: String) {
        activity?.let {
            val builder: AlertDialog.Builder = AlertDialog.Builder(it)
            val customLayout: View = layoutInflater.inflate(R.layout.widget_dialog_warning, null)
            val tvMessage = customLayout.findViewById<TextView>(R.id.msg_content)
            tvMessage?.let { content ->
                content.text = msg
            }
            builder.setView(customLayout)
            val dialog: AlertDialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            customLayout.findViewById<Button>(R.id.btn_no).setOnClickListener { dialog.dismiss() }
            customLayout.findViewById<ImageView>(R.id.btn_close)
                .setOnClickListener { dialog.dismiss() }

            dialog.window?.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dialog.show()
        }
    }

    fun showErrorPopup(resTitleId: Int, content: String) {
        if (errorPopup == null || !errorPopup?.isShowing!!) {
            initErrorPopup(getString(resTitleId), content)
        }
    }

    override fun showErrorPopup(resTitleId: Int, resContentId: Int) {
        if (errorPopup == null || !errorPopup?.isShowing!!) {
            initErrorPopup(getString(resTitleId), getString(resContentId))
        }
    }

    private fun initErrorPopup(title: String, content: String) {
        activity?.let {
            val builder: AlertDialog.Builder = AlertDialog.Builder(it)
            // set the custom layout
            val customLayout: View = layoutInflater.inflate(R.layout.widget_dialog_error, null)
            builder.setView(customLayout)
            errorPopup = builder.create()
            errorPopup?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            customLayout.findViewById<TextView>(R.id.title).setText(title)
            customLayout.findViewById<TextView>(R.id.msg_content).setText(content)
            customLayout.findViewById<ImageView>(R.id.btn_close).setOnClickListener {
                errorPopup?.dismiss()
                errorPopup = null
            }
            customLayout.findViewById<Button>(R.id.btn_close_2).setOnClickListener {
                errorPopup?.dismiss()
                errorPopup = null
            }
            errorPopup?.window?.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)
            errorPopup?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            errorPopup?.show()
        }
    }

    override fun showConfirmPopup(resTitleId: Int, resContentId: Int?, completion: () -> Unit) {
        activity?.let {
            val builder: AlertDialog.Builder = AlertDialog.Builder(it)
            val customLayout: View = layoutInflater.inflate(R.layout.widget_dialog_confirm, null)
            builder.setView(customLayout)
            val dialog: AlertDialog = builder.create()
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            customLayout.findViewById<TextView>(R.id.title).setText(resTitleId)

            resContentId?.let { id ->
                customLayout.findViewById<TextView>(R.id.msg_content).setText(id)
            }
            customLayout.findViewById<Button>(R.id.btn_cancel)
                .setOnClickListener { dialog.dismiss() }
            customLayout.findViewById<ImageView>(R.id.btn_close)
                .setOnClickListener { dialog.dismiss() }
            customLayout.findViewById<Button>(R.id.btn_confirm).setOnClickListener {
                dialog.dismiss()
                completion.invoke()
            }
            dialog.window?.setGravity(Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
        }
    }

}