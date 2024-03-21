package com.ubaya.advweek4nrp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.ubaya.advweek4nrp.R


class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private lateinit var binding: FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

        // Observe Student LiveData
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer { students ->
            // Assuming you want to display the first student in the list
            if (students.isNotEmpty()) {
                val student = students[0] // Get the first student
                // Set the EditText values
                binding.txtID.setText(student.id)
                binding.txtName.setText(student.name)
                binding.txtBod.setText(student.bod)
                binding.txtPhone.setText(student.phone)
            }
        })
    }
}