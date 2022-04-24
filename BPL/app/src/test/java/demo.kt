class demo {
    BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when(item.itemId) {
            R.id.home -> {
                Toast.makeText(this,"one", Toast.LENGTH_LONG).show()
                true
            }
            R.id.message -> {
                Toast.makeText(this,"two",Toast.LENGTH_LONG).show()
                true
            }
                else -> false
        }
        }
}