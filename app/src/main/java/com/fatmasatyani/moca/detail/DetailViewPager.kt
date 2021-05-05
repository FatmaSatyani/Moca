package com.fatmasatyani.moca.detail

//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentStatePagerAdapter
//import com.fatmasatyani.moca.about.AboutFragment
//import com.fatmasatyani.moca.description.DescriptionFragment
//
//class DetailViewPager(viewPagerManager: FragmentManager, private val movieId: String, private val tvShowId: String, BEHAVIOR_SET_USER_VISIBLE_HINT: Int = 0) : FragmentStatePagerAdapter(viewPagerManager, BEHAVIOR_SET_USER_VISIBLE_HINT) {
//
//    override fun getItem(position: Int): Fragment {
//        return when (position) {
//            0 -> DescriptionFragment.newInstance(movieId, tvShowId)
//            else -> AboutFragment.newInstance(movieId, tvShowId)
//        }
//    }
//
//    override fun getCount(): Int = 2
//
////    override fun getPageTitle(position: Int): CharSequence? {
////        return when (position) {
////            0 -> "Description"
////            else -> "About"
////        }
////    }
//}
